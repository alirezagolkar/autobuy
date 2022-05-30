package com.dealers.autobuy.model;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity for client and vehicle
 * @author Ali Golkar
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "client_vehicle")
public class ClientVehicle {

    @EmbeddedId
    private ClientVehicleId id = new ClientVehicleId();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("client_id")
    @JoinColumn(name = "client_id")
    private Client client;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("vehicle_id")
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    private Integer bidPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientVehicle that = (ClientVehicle) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(client, that.client) &&
                Objects.equals(vehicle, that.vehicle) &&
                Objects.equals(bidPrice, that.bidPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, vehicle, bidPrice);
    }
}
