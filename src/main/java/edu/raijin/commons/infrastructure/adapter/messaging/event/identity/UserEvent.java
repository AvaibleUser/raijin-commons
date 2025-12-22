package edu.raijin.commons.infrastructure.adapter.messaging.event.identity;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEvent {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

    private String role;

    private String color;

    private String code;
}
