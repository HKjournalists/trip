/*
    This file is part of Cyclos (www.cyclos.org).
    A project of the Social Trade Organisation (www.socialtrade.org).

    Cyclos is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    Cyclos is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Cyclos; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA

 */
package com.otrip.webservice.util;

import java.io.Serializable;

/**
 * Parameters used to search for a member by one of it's principals
 * 
 * @author luis
 */
public class PrincipalParameters implements Serializable {

    private static final long serialVersionUID = 7870025837827799653L;
    private String            principalType;
    private String            principal;

    public String getPrincipal() {
        return principal;
    }

    public String getPrincipalType() {
        return principalType;
    }

    public void setPrincipal(final String principal) {
        this.principal = principal;
    }

    public void setPrincipalType(final String principalType) {
        this.principalType = principalType;
    }

    @Override
    public String toString() {
        return "PrincipalParameters [principal=" + principal + ", principalType=" + principalType + "]";
    }

}