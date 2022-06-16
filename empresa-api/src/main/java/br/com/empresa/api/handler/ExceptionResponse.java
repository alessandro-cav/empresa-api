package br.com.empresa.api.handler;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

	private String message;

	private String descrition;

	private LocalDateTime timestamp;
}
