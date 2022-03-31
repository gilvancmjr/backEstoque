package br.com.monteiro.fullstack.exceptions;

import java.io.Serializable;
import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandarError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Instant timestemp;
	private Integer status;
	private String error;
	private String message;
	private String path;
}
