package com.example.user.masterplanner.Utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by emmanuel on 2018-04-20.
 */

public class AnnoHelper{
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ApplicationContext{}
}
