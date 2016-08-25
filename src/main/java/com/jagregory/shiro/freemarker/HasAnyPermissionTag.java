/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.jagregory.shiro.freemarker;

import org.apache.shiro.subject.Subject;


/**
 * Displays body content if the current user has any of the roles specified.
 *
 * <p>Equivalent to {HasAnyPermissionTag}</p>
 *
 * @since 0.2
 */
public class HasAnyPermissionTag extends PermissionTag {
    // Delimeter that separates permission names in tag attribute
    private static final String PERMISSION_NAMES_DELIMETER = ",";

    protected boolean showTagBody(String roleNames) {
        boolean hasAnyPermission = false;
        Subject subject = getSubject();

        if (subject != null) {
            // Iterate through roles and check to see if the user has one of the roles
            for (String role : roleNames.split(PERMISSION_NAMES_DELIMETER)) {
                if (subject.isPermitted(role.trim())) {
                    hasAnyPermission = true;
                    break;
                }
            }
        }

        return hasAnyPermission;
    }
}