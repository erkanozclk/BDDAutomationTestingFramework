package utils.ui.getProperties;

import utils.config.ConfigurationReader;
import utils.ui.enums.DeviceTypeEnums;

public class GetDeviceType {

    private String deviceType = ConfigurationReader.getProperty("deviceType");

    public DeviceTypeEnums getDevice() {

        if (deviceType.equalsIgnoreCase("DESKTOP")) {

            return DeviceTypeEnums.DESKTOP;

        } else if (deviceType.equalsIgnoreCase("IPHONE")) {

            return DeviceTypeEnums.IPHONE;

        } else if (deviceType.equalsIgnoreCase("TABLET")) {

            return DeviceTypeEnums.TABLET;

        } else if (deviceType.equalsIgnoreCase("ANDROID_PHONE")) {

            return DeviceTypeEnums.ANDROID_PHONE;

        } else if (deviceType.equalsIgnoreCase("IPAD")) {

            return DeviceTypeEnums.IPAD;

        }  else {

            throw new RuntimeException("No browser name specified in properties file at: " + deviceType + ". Please specify the correct DeviceType name");

        }

    }
}
