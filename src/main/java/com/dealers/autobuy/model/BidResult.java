package com.dealers.autobuy.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Json Object for bid result
 * @author Ali Golkar
 */
@Getter
@Setter
@NoArgsConstructor
public class BidResult {

    private String clientName;
    private String clientId;
    private String vehicleName;
    private String vehicleId;
    private String dealerName;
    private String dealerId;
    private String bidPrice;
}
