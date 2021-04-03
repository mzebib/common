package com.github.mzebib.common.data.security;

import com.github.mzebib.common.util.SetNameDescription;
import com.github.mzebib.common.util.SubjectId;

/**
 * @author mzebib
 */
public interface Subject
        extends SubjectId, SetNameDescription, RoleGroup {

    SubjectType getSubjectType();

    void setSubjectType(SubjectType type);

}