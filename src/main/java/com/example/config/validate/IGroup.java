package com.example.config.validate;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({ First.class,Default.class, Second.class})
public interface IGroup {
}