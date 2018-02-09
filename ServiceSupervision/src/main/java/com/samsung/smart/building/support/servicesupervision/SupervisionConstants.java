/**
 * Project: Quaduron
 *
 * Copyright (c) 2017 DMC R&D Center, SAMSUNG ELECTRONICS Co.,LTD.
 * (Maetan dong)129, Samsung-ro Yeongtong-gu, Suwon-si. Gyeonggi-do 443-742, Korea
 * All right reserved.
 *
 * This software is the confidential and proprietary information of Samsung Electronics, Inc.
 * ("Confidential Information"). You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement you entered
 * into with Samsung Electronics.
 */

package com.samsung.smart.building.support.servicesupervision;

import com.samsung.smart.building.support.servicesupervision.core.utils.LogAnalyzer;

import java.io.File;
import java.time.LocalDate;

/**
 * Constants for ServiceSupervision
 *
 * @author Samsung R&amp;D Institute India - Bangalore.
 */
public interface SupervisionConstants {

    /**
     * The interface Launcher.
     */
    interface Launcher {
        /**
         * The constant OS.
         */
        String OS = System.getProperty("os.name").toLowerCase();

        /**
         * The constant DRIVE_PATH.
         */
        String DRIVE_PATH = OS.contains("win") ? "C:" : System.getProperty("user.home");

        /**
         * The constant PROGRAM_FILES
         */
        String PROGRAM_FILES = "Program Files";

        /**
         * The constant BIOT_CENTER_PATH.
         */
        String BIOT_CENTER_PATH = PROGRAM_FILES +
                File.separator +
                "Samsung" +
                File.separator +
                "b.IoT";

        /**
         * The constant SERVICE_LAUNCH_CONFIG_FILE.
         */
        String SERVICE_LAUNCH_CONFIG_FILE = "ServiceLaunchConfig.conf";

        /**
         * The constant SERVICE_LAUNCH_CONFIG_PATH.
         */
        String SERVICE_LAUNCH_CONFIG_PATH = DRIVE_PATH +
                File.separator +
                BIOT_CENTER_PATH +
                File.separator +
                "config";

        /**
         * The constant SERVICE_LAUNCH_CONFIG_FILE_PATH.
         */
        String SERVICE_LAUNCH_CONFIG_FILE_PATH = SupervisionConstants.Launcher.SERVICE_LAUNCH_CONFIG_PATH
                +  File.separator + SupervisionConstants.Launcher.SERVICE_LAUNCH_CONFIG_FILE;

        /**
         * The constant SERVICES_JAR_PATH.
         */
        String SERVICES_JAR_PATH = DRIVE_PATH +
                File.separator +
                BIOT_CENTER_PATH;

        /**
         * The constant JAVA_PATH.
         */
        String JAVA_PATH = System.getenv("JAVA_HOME")+
                File.separator +
                "bin" +
                File.separator +
                "java";

        /**
         * The constant TOMCAT_SERVER_STARTUP_SCRIPT.
         */
        String TOMCAT_SERVER_STARTUP_SCRIPT = "startup.bat";
        /**
         * The constant TOMCAT_SERVER_SHUTDOWN_SCRIPT.
         */
        String TOMCAT_SERVER_SHUTDOWN_SCRIPT = "shutdown.bat";

        /**
         * The constant TOMCAT_PATH.
         */
        String TOMCAT_PATH = DRIVE_PATH +
                File.separator +
                "Tomcat";

        /**
         * The constant TOMCAT_SERVER_PATH.
         */
        String TOMCAT_SERVER_PATH = TOMCAT_PATH +
                File.separator +
                "bin";

        /**
         * The constant LOG_FILE_PATH.
         */
        String LOG_FILE_PATH = LogAnalyzer.getLogName() +
                "ServiceError";
        /**
         * The constant TOMCAT_LOG_FILE.
         */
        String TOMCAT_LOG_FILE = LOG_FILE_PATH + File.separator + "Tomcat_Log_"
                + LocalDate.now().getYear() + "_" + LocalDate.now().getMonthValue() + "_" + LocalDate.now().getDayOfMonth() + ".log";


        /**
         * The constant CATALINA_LOG_FILE.
         */
        String CATALINA_LOG_FILE = TOMCAT_PATH + File.separator + "logs" + File.separator + "catalina."
                + LocalDate.now().getYear() + "-" + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getDayOfMonth() + ".log";

        /**
         * The constant MAX_DELAY.
         */
        long MAX_DELAY = 30000L;
        /**
         * The constant DEFAULT_TIMEOUT.
         */
        long DEFAULT_TIMEOUT = 1000L;
        /**
         * The constant PROCESS_HEALTH_DELAY.
         */
        long PROCESS_HEALTH_DELAY = 3000L;
        /**
         * The constant PASSWORD_CHANGER_LAUNCH_DELAY.
         */
        long PASSWORD_CHANGER_LAUNCH_DELAY = 10000L;

        /**
         * The constant MAX_RETRY_COUNT.
         */
        int MAX_RETRY_COUNT = 3;
    }

    /**
     * The interface Notification.
     */
    interface Notification {
        /**
         * The constant HEADER_LABEL.
         */
        String HEADER_LABEL = "BIoT Center";
        /**
         * The constant STARTING_QUADURON.
         */
        String STARTING_QUADURON = "Starting Quaduron...";
        /**
         * The constant QUADURON_FAIL_MESSAGE.
         */
        String QUADURON_FAIL_MESSAGE = "service has problem";
        /**
         * The constant QUADURON_SERVICE_STARTED_MESSAGE.
         */
        String QUADURON_SERVICE_STARTED_MESSAGE = "Services started !";
        /**
         * The constant QUADURON_SERVICE_STOPPED_MESSAGE.
         */
        String QUADURON_SERVICE_STOPPED_MESSAGE = "Services stopped.";
        /**
         * The constant QUADURON_SERVICE_RESTART_MESSAGE.
         */
        String QUADURON_SERVICE_RESTART_MESSAGE = "Services restarting...";
        /**
         * The constant QUADURON_SERVICE_STOPPING_MESSAGE.
         */
        String QUADURON_SERVICE_STOPPING_MESSAGE = "Services stopping...";
        /**
         * The constant QUADURON_SUCCESS_MESSAGE.
         */
        String QUADURON_SUCCESS_MESSAGE = "Quaduron started successfully !";

        /**
         * The constant STARTING_TOMCAT.
         */
        String STARTING_TOMCAT = "Starting Tomcat...";
        /**
         * The constant STOPPING_TOMCAT.
         */
        String STOPPING_TOMCAT = "Stopping Tomcat...";
        /**
         * The constant TOMCAT_START_FAILED_MESSAGE.
         */
        String TOMCAT_START_FAILED_MESSAGE = "Unable to start Tomcat webserver";
        /**
         * The constant TOMCAT_STOP_FAILED_MESSAGE.
         */
        String TOMCAT_STOP_FAILED_MESSAGE = "Unable to stop Tomcat webserver";
        /**
         * The constant TOMCAT_FAILED_MESSAGE_RETRY.
         */
        String TOMCAT_FAILED_MESSAGE_RETRY = "Unable to start Tomcat, retrying ";
        /**
         * The constant TOMCAT_START_SUCCESS_MESSAGE.
         */
        String TOMCAT_START_SUCCESS_MESSAGE = "Tomcat started successfully !";
        /**
         * The constant TOMCAT_STOP_SUCCESS_MESSAGE.
         */
        String TOMCAT_STOP_SUCCESS_MESSAGE = "Tomcat stopped successfully !";
    }

    /**
     * The interface Launcher monitor.
     */
    interface LauncherMonitor {
        /**
         * The constant TITLE.
         */
        String TITLE = "b.IoT Launcher";
        /**
         * The constant START_BUTTON.
         */
        String START_BUTTON = "Start";
        /**
         * The constant STOP_BUTTON.
         */
        String STOP_BUTTON = "Stop";
        /**
         * The constant STATUS_LABEL.
         */
        String STATUS_LABEL = "Initializing...";
        /**
         * The constant COLUMN_SERVICE_NAME.
         */
        String COLUMN_SERVICE_NAME = "Service_Name";
        /**
         * The constant COLUMN_SERVICE_STATUS.
         */
        String COLUMN_SERVICE_STATUS = "Service_Status";
        /**
         * The constant CONFIRM_DIALOG_MSG.
         */
        String CONFIRM_DIALOG_MSG = "Are you sure you want exit b.IoT ?";
    }

    /**
     * The interface Supervision.
     */
    interface Supervision {
        /**
         * The constant BRINGING_UP.
         */
        String BRINGING_UP = "Bringing up";
    }
}
