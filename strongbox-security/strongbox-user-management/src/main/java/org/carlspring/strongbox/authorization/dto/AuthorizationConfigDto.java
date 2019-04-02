package org.carlspring.strongbox.authorization.dto;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Java representation for authorization config that stored in YAML file.
 *
 * @author Alex Oreshkevich
 * @author Pablo Tirado
 * @see /src/main/resources/etc/conf/strongbox-authorization.yaml
 * @see {@linkplain https://dev.carlspring.org/youtrack/issue/SB-126}
 */
@JsonRootName("authorizationConfiguration")
public class AuthorizationConfigDto
        implements Serializable
{

    private Set<RoleDto> roles = new LinkedHashSet<>();

    private Set<PrivilegeDto> privileges = new LinkedHashSet<>();

    public Set<RoleDto> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<RoleDto> roles)
    {
        this.roles = roles;
    }

    public Set<PrivilegeDto> getPrivileges()
    {
        return privileges;
    }

    public void setPrivileges(final Set<PrivilegeDto> privileges)
    {
        this.privileges = privileges;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o) return true;
        if (!(o instanceof AuthorizationConfigDto))
        {
            return false;
        }
        final AuthorizationConfigDto config = (AuthorizationConfigDto) o;
        return java.util.Objects.equals(roles, config.roles) &&
               java.util.Objects.equals(privileges, config.privileges);
    }

    @Override
    public int hashCode()
    {
        return java.util.Objects.hash(roles, privileges);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("AuthorizationConfig{");
        sb.append("roles=").append(roles);
        sb.append(", privileges=").append(privileges);
        sb.append('}');
        return sb.toString();
    }

}
