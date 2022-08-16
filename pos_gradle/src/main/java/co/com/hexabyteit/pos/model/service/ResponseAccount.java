package co.com.hexabyteit.pos.model.service;

import co.com.hexabyteit.pos.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseAccount {
    private UserEntity account;
}
