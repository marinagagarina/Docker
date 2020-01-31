package ru.netology;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

public class CardDeliveryInfo {
    private final String city;
    private final LocalDate deliveryData;
    private final String surName;
    private final String name;
    private final String phone;

    public String getCity() {
        return this.city;
    }

    public LocalDate getDeliveryData() {
        return this.deliveryData;
    }

    public String getSurName() {
        return this.surName;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CardDeliveryInfo)) return false;
        final CardDeliveryInfo other = (CardDeliveryInfo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        final Object this$deliveryData = this.getDeliveryData();
        final Object other$deliveryData = other.getDeliveryData();
        if (this$deliveryData == null ? other$deliveryData != null : !this$deliveryData.equals(other$deliveryData)) return false;
        final Object this$surName = this.getSurName();
        final Object other$surName = other.getSurName();
        if (this$surName == null ? other$surName != null : !this$surName.equals(other$surName)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$phone = this.getPhone();
        final Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CardDeliveryInfo;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final Object $deliveryData = this.getDeliveryData();
        result = result * PRIME + ($deliveryData == null ? 43 : $deliveryData.hashCode());
        final Object $surName = this.getSurName();
        result = result * PRIME + ($surName == null ? 43 : $surName.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "CardDeliveryInfo(city=" + this.getCity() + ", deliveryData=" + this.getDeliveryData() + ", surName=" + this.getSurName() + ", name=" + this.getName() + ", phone=" + this.getPhone() + ")";
    }

    public CardDeliveryInfo(final String city, final LocalDate deliveryData, final String surName, final String name, final String phone) {
        this.city = city;
        this.deliveryData = deliveryData;
        this.surName = surName;
        this.name = name;
        this.phone = phone;
    }
}
