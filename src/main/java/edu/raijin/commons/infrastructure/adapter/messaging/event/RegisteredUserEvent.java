package edu.raijin.commons.infrastructure.adapter.messaging.event;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisteredUserEvent implements Serializable {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String code;
}
