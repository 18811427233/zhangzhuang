package demo.mirror.com.mylibrary;

/*
 * Copyright (C) 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.util.Log;

public class HttpSessionConfiguration {

    private static final int DEFAULT_TIME_OUT = 10 * 1000;
    private static final boolean DEFAULT_LOGGING_ENABLED = true;
    private static final int DEFAULT_LOG_LEVEL = Log.VERBOSE;

    //////////////////////////////////////////////////////////////////////////////////////
    // PRIVATE MEMBERS
    //////////////////////////////////////////////////////////////////////////////////////

    private Context context;
    private String userAgent;
    private int timeOut;
    private Boolean loggingEnabled;
    private Integer logLevel;

    //////////////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////////////////////////////////////////////////////////

    private HttpSessionConfiguration(Context context) {
        this.context = context;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    // PUBLIC METHODS
    //////////////////////////////////////////////////////////////////////////////////////

    public Context getContext() {
        return context;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public Boolean getLoggingEnabled() {
        return loggingEnabled;
    }

    public Integer getLogLevel() {
        return logLevel;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    // INNER CLASSES
    //////////////////////////////////////////////////////////////////////////////////////

    public static class Builder {
        //////////////////////////////////////////////////////////////////////////////////////
        // PRIVATE CONSTANTS
        //////////////////////////////////////////////////////////////////////////////////////

        //////////////////////////////////////////////////////////////////////////////////////
        // PRIVATE MEMBERS
        //////////////////////////////////////////////////////////////////////////////////////

        private Context context;
        private String userAgent;
        private Integer timeOut;
        private Boolean loggingEnabled;
        private Integer logLevel;

        //////////////////////////////////////////////////////////////////////////////////////
        // CONSTRUCTORS
        //////////////////////////////////////////////////////////////////////////////////////

        public Builder(Context context) {
            this.context = context.getApplicationContext();
        }

        public Builder setUserAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public Builder setTimeOut(Integer timeOut) {
            this.timeOut = timeOut;
            return this;
        }

        public Builder setLoggingEnabled(Boolean loggingEnabled) {
            this.loggingEnabled = loggingEnabled;
            return this;
        }

        public Builder setLogLevel(Integer logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        //////////////////////////////////////////////////////////////////////////////////////
        // PUBLIC METHODS
        //////////////////////////////////////////////////////////////////////////////////////

        public HttpSessionConfiguration create() {
            HttpSessionConfiguration configuration = new HttpSessionConfiguration(context);

            // SET USER AGENT
            configuration.userAgent = userAgent;

            // SET TIME OUT
            if (timeOut == null) {
                configuration.timeOut = DEFAULT_TIME_OUT;
            } else {
                configuration.timeOut = timeOut;
            }

            // SET LOGGING ENABLED
            if (loggingEnabled == null) {
                configuration.loggingEnabled = DEFAULT_LOGGING_ENABLED;
            } else {
                configuration.loggingEnabled = loggingEnabled;
            }

            // SET LOG LEVEL
            if (logLevel == null) {
                configuration.logLevel = DEFAULT_LOG_LEVEL;
            } else {
                configuration.logLevel = logLevel;
            }

            return configuration;
        }

    }
}
