package com.dealers.autobuy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class ClientVehicleId implements Serializable {

    @Column(name = "client_id")
    private int client_id;

    @Column(name = "vehicle_id")
    private int vehicle_id;
}
