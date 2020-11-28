package de.stvehb.example.serverless.repository.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class UserModel extends PanacheEntityBase {

	@Id
	@GeneratedValue(generator = "org.hibernate.id.UUIDGenerator")
	private UUID id;


	@NotBlank @Size(min = 5, max = 20)
	private String username;

}
