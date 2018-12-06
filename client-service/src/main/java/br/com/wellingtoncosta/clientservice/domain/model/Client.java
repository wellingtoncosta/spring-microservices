package br.com.wellingtoncosta.clientservice.domain.model;

import lombok.Data;

/**
 * @author Wellington Costa on 05/12/18
 */
@Data public class Client {

    private Long id;
    private String name;
    private String email;
    private String phone;

}
