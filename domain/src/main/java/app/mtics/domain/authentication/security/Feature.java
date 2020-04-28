package app.mtics.domain.authentication.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public enum Feature {
    VIEW_MEMBERS(Role.SYSADMIN);

    private Role[] roles;

    Feature(Role... roles) {this.roles = roles; }

    public List<Role> getRoles() { return newArrayList(roles); }

    public static List<Feature> getFeaturesForRoles(List<String> rolesOfUserAsString) {
        List<Role> rolesOfUser = rolesOfUserAsString.stream()
                .map(Role::valueOf)
                .collect(Collectors.toList());
        return Arrays.stream(Feature.values())
                .filter(feature -> !Collections.disjoint(feature.getRoles(), rolesOfUser))
                .collect(Collectors.toList());
    }
}
