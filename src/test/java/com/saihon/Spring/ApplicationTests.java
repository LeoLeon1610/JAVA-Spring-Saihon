package com.saihon.Spring;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saihon.Spring.dto.ChangePassword;
import com.saihon.Spring.model.Categoria;
import com.saihon.Spring.model.LibroPedido;
import com.saihon.Spring.model.Libros;
import com.saihon.Spring.model.Pedido;
import com.saihon.Spring.model.Usuario;

//métodos Get Put Delete Post
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

//información acerca de 
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//información acerca del estatus
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.hamcrest.Matchers.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private PasswordEncoder encoder;
	
	private final String token = "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqY0BnbWFpbC5jb20iLCJyb2xlIjoidXNlciIsImlhdCI6MTcyMDY0NzY2NywiZXhwIjoxNzIwNjgzNjY2fQ.x_Ds8N2lX8yRAbeo9Q2FnK0lHJiPFnLbrknpCx-PpJY";
//********pruebas Pedidos******	
	@Test
	@DisplayName("Se prueba el GET del endpoint http://localhost:8080/api/pedidos/1")
	@Disabled("Probado metodo GET Pedidos")
	void pruebaGET() throws Exception{
		this.mockMvc.perform(get("/api/pedidos/") )
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString("Villa Bonita #243 Alboreda"))
				);
	}//pruebaGET
	
	
	@Test
	@DisplayName("Se prueba el DELETE Pedidos del endpoint http://localhost:8080/api/pedidos/2")
	@Disabled("Probado una vez, deshabilitado porque ya se realizó")
	void pruebaDELETE() throws Exception{
		this.mockMvc.perform( delete("/api/pedidos/1")
				.header("Autorization", token) 
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString("tarjeta debito"))
				);
	}//PruebaDELETE
	
	@Test
	@DisplayName("Prueba post")
	@Disabled("Metodo POST Pedidos")
	void pruebaPOST() throws Exception{
		Pedido p = new Pedido();
		p.setDomicilio("Inglaterra #285 Virreyes");
		p.setForma_de_pago("Tarjeta debito");
		p.setStatus("Concluido");
		
		this.mockMvc.perform( post("/api/pedidos/")
				.contentType(MediaType.APPLICATION_JSON)
				.content( asJsonString(p))
				.header("Autorization", token) 
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString("Tarjeta debito"))
				);
	}//PruebaPost

	private static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
	 } // asJsonString

	@Test
	@DisplayName("Se prueba el PUT, modificar un pedido, el 1")
	//@Disabled("Probando metodo PUT Pedidos")
	void pruebaPUT() throws Exception{
		this.mockMvc.perform( put("/api/pedidos/1")
				.queryParam("status", "finalizado")
				.header("Autorization", token) 
				)
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect( content().string(containsString("finalizado"))
				);
	}//PruebaPUT
	
//********PRUEBAS LIBROS*****
	@Test
	@DisplayName("Se prueba el get LIBROS del endpoint http://localhost8080/api/usuarios/2")
	@Disabled("Probado metodo GET libros")
	void pruebaGETLibros() throws Exception {
		this.mockMvc.perform(get("/api/libros/") )
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Claro de Luna"))
				);
		
	}//pruebaGetLibros
	
	@Test
	@DisplayName("Se prueba el DELETE LIBROS del endpoint http://localhost8080/libros/3")
	@Disabled("Probado una vez, deshabilitado porque ya no existe el método :c)=")
	void pruebaDELETELibros() throws Exception {
		this.mockMvc.perform(delete("/api/libros/2")
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Claro de Luna"))
				);
		
	}//pruebaDELETELibros
	
	@Test
	@DisplayName("Se prueba el POST LIBROS del endpoint http://localhost8080/api/libros/")
	@Disabled("Probado una vez, deshabilitado porque ya no existe el método :c")
	void pruebaPOSTLibros() throws Exception {
		Libros p= new Libros();
		p.setNombreLibro("Claro de Luna");
		p.setDescripcion("El libro más reciente de Javier Santaolalla");
		p.setAutor("Javier Santaolalla");
		p.setCantidadStock(44);
		p.setCategoria(3);
		p.setEditorial("OCEANO");
		p.setPortada("BigBang.jpg");
		p.setPrecio(399.00);
		p.setYear(2019);
		this.mockMvc.perform(post("/api/libros/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Claro de Luna"))
				);
	}//pruebaLibrosPOST
	
	@Test
	@DisplayName("Se prueba modificar un producto con id 1")
	//@Disabled("Metoso PUT Libros")
	void pruebaPUTLibros() throws Exception {
		this.mockMvc.perform(put("/api/libros/2")
				.queryParam("precio", "350.2")
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("350.2"))
				);
		
	}//pruebaPutLibros
	
//********PRUEBAS CATEGORIAS*****
	@Test
	@DisplayName("Prueba GET de categorias")
	@Disabled("Metoso GET Categorias")
	    void pruebaGetCategorias() throws Exception {
	        this.mockMvc.perform(get("/api/categorias/"))
	                .andDo(print())
	                .andExpect(status().isOk())
	                .andExpect(content().string(containsString("")));
	    }//get
	
	@Test
    @DisplayName("Prueba DELETE de productos")
	@Disabled("Metoso DELETE Categorias")
    void pruebaDeleteProductos() throws Exception {
        this.mockMvc.perform(delete("/api/categorias/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Terror")));
    }//deteleCategorias
	
	@Test
    @DisplayName("Prueba POST de categorias")
	@Disabled("Metoso POST Categorias")
    void pruebaPostCategorias() throws Exception {
        Categoria categoria = new Categoria();
        categoria.setNombre("Romance"); 

        this.mockMvc.perform(post("/api/categorias/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(categoria))
                .header("Authorization",  token)) 
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Romance")));
    }//post
	
	@Test
    @DisplayName("Prueba PUT de categorias")
	@Disabled("Metoso PUT Categorias")
    void pruebaPutCategorias() throws Exception {
        this.mockMvc.perform(put("/api/categorias/3")
                .queryParam("nombre", "Accion") 
                .header("Authorization", token))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Accion")));
    }//putCategorias

	//********LIBRO PEDIDOS*****
	
/*	@Test
    @DisplayName("Se prueba el GET ")
	@Disabled("Metodos GET LIBROPEDIDO")
    void pruebaGETLP() throws Exception {
        this.mockMvc.perform(get("/api/libroPedido/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(""))); // Ajustar
    }

    @Test
    @DisplayName("Se prueba el DELETE")
    @Disabled("Metodo DELETE LIBROPEDIDO")
    void pruebaDELETELP() throws Exception {
        this.mockMvc.perform(delete("/api/libroPedido/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(""))); // Ajustar
    }

    @Test
    @DisplayName("Se prueba POST")
    //@Disabled("Metodo POST LIBROPEDIDO")
    void pruebaPOSTLP() throws Exception {
        LibroPedido libroPedido = new LibroPedido((long) 1,(long) 4, (long) 4);
				libroPedido.setLibro((long)1);
				libroPedido.setPedido((long)1); 

        this.mockMvc.perform(post("/api/libroPedido/")
        		.contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(libroPedido)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("LibroPedido creado")));
                		
    }

    @Test
    @DisplayName("Se prueba el PUT")
    @Disabled("Metodo PUT LIBROPEDIDO")
    void pruebaPUTLP() throws Exception {
        this.mockMvc.perform(put("/api/libroPedido/1")
        		   .contentType(MediaType.APPLICATION_JSON)
                   .andDo(print())
                   .andExpect(status().isOk())
                   .andExpect(content().string(containsString("LibroPedido actualizado"))));
    }*/
	
	//********LIBRO USUARIOS*****
	@Test
	@DisplayName("Se prueba el get del endpoint http://localhost8080/api/usuarios/2")
	@Disabled("Metodo GET USUARIOS")
	void pruebaGETUsuarios() throws Exception {
		this.mockMvc.perform(get("/api/usuarios/1").header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("andymilller@hotmail.com")));
		
	}//pruebaGetLibros
	
	@Test
	@DisplayName("Se prueba el DELETE del endpoint http://localhost8080/usuarios/3")
	@Disabled("Metodo DELETE USUARIOS")
	void pruebaDELETEUsuarios() throws Exception {
		this.mockMvc.perform(delete("/api/usuarios/2")
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("braulioiac@gmail.com"))
				);
		
	}//pruebaDELETELibros
	
	@Test
	@DisplayName("Se prueba el POST del endpoint http://localhost8080/api/usuarios/")
	@Disabled("Metodo POST USUARIOS")
	void pruebaPOSTUsuarios() throws Exception {
		Usuario u= new Usuario();
		u.setEmail("braulioiac@gmail.com");
		u.setNombre("Barulio Alejo");
		u.setPassword("Abc123@!");
		this.mockMvc.perform(post("/api/usuarios/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(u))
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("braulioiac@gmail.com"))
				);
	}//POST Usuario
	
	@Test
	@DisplayName("Se prueba modificar un producto con id 1")
	@Disabled("Metodo PUT USUARIOS")
	void pruebaPUTUsuarios() throws Exception {
		ChangePassword p = new ChangePassword();
		p.setPassword(encoder.encode("Abc123@!"));
		p.setNpassword(encoder.encode("Pa$$w0rd"));
		this.mockMvc.perform(put("/api/usuarios/3")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString(encoder.encode("Pa$$w0rd"))) //queda pendiente arreglar encode
				);
		
	}//pruebaPutUsuarios
	
	
	
	
	
	
}//classAplicationTest