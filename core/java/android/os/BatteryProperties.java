/* Copyright 2013, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package android.os;

/**
 * {@hide}
 */
public class BatteryProperties implements Parcelable {
    public boolean chargerAcOnline;
    public boolean chargerUsbOnline;
    public boolean chargerWirelessOnline;
    public int maxChargingCurrent;
    public int maxChargingVoltage;
    public int batteryStatus;
    public int batteryHealth;
    public boolean batteryPresent;
    public int batteryLevel;
    public int batteryVoltage;
    public int batteryTemperature;
    public int batteryFullCharge;
    public int batteryChargeCounter;
    public String batteryTechnology;
    
    public int modLevel;
    public int modStatus;
    public int modType;
    public int modFlag;

    public BatteryProperties() {
    }

    public void set(BatteryProperties other) {
        chargerAcOnline = other.chargerAcOnline;
        chargerUsbOnline = other.chargerUsbOnline;
        chargerWirelessOnline = other.chargerWirelessOnline;
        maxChargingCurrent = other.maxChargingCurrent;
        maxChargingVoltage = other.maxChargingVoltage;
        batteryStatus = other.batteryStatus;
        batteryHealth = other.batteryHealth;
        batteryPresent = other.batteryPresent;
        batteryLevel = other.batteryLevel;
        batteryVoltage = other.batteryVoltage;
        batteryTemperature = other.batteryTemperature;
        batteryFullCharge = other.batteryFullCharge;
        batteryChargeCounter = other.batteryChargeCounter;
        batteryTechnology = other.batteryTechnology;
        modLevel = other.modLevel;
        modStatus = other.modStatus;
        modType = other.modType;
        modFlag = other.modFlag;
    }

    /*
     * Parcel read/write code must be kept in sync with
     * frameworks/native/services/batteryservice/BatteryProperties.cpp
     */

    private BatteryProperties(Parcel p) {
        chargerAcOnline = p.readInt() == 1 ? true : false;
        chargerUsbOnline = p.readInt() == 1 ? true : false;
        chargerWirelessOnline = p.readInt() == 1 ? true : false;
        maxChargingCurrent = p.readInt();
        maxChargingVoltage = p.readInt();
        batteryStatus = p.readInt();
        batteryHealth = p.readInt();
        batteryPresent = p.readInt() == 1 ? true : false;
        batteryLevel = p.readInt();
        batteryVoltage = p.readInt();
        batteryTemperature = p.readInt();
        batteryFullCharge = p.readInt();
        batteryChargeCounter = p.readInt();
        batteryTechnology = p.readString();
        modLevel = p.readInt();
        modStatus = p.readInt();
        modType = p.readInt();
        modFlag = p.readInt();
    }

    public void writeToParcel(Parcel p, int flags) {
        p.writeInt(chargerAcOnline ? 1 : 0);
        p.writeInt(chargerUsbOnline ? 1 : 0);
        p.writeInt(chargerWirelessOnline ? 1 : 0);
        p.writeInt(maxChargingCurrent);
        p.writeInt(maxChargingVoltage);
        p.writeInt(batteryStatus);
        p.writeInt(batteryHealth);
        p.writeInt(batteryPresent ? 1 : 0);
        p.writeInt(batteryLevel);
        p.writeInt(batteryVoltage);
        p.writeInt(batteryTemperature);
        p.writeInt(batteryFullCharge);
        p.writeInt(batteryChargeCounter);
        p.writeString(batteryTechnology);
        p.writeInt(modLevel);
        p.writeInt(modStatus);
        p.writeInt(modType);
        p.writeInt(modFlag);
    }

    public static final Parcelable.Creator<BatteryProperties> CREATOR
        = new Parcelable.Creator<BatteryProperties>() {
        public BatteryProperties createFromParcel(Parcel p) {
            return new BatteryProperties(p);
        }

        public BatteryProperties[] newArray(int size) {
            return new BatteryProperties[size];
        }
    };

    public int describeContents() {
        return 0;
    }
}
