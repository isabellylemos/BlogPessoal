package org.generation.blogpessoal.model;


public class UsuarioLogin {
	
	private long Id;

	private String nome;

	private String usuario ;

	private String senha; 

	private String   foto ;
	
	private String  tipo ;

	private String token ;
	
	

	public UsuarioLogin(long id, String nome, String usuario, String senha, String foto, String  tipo, String token) {
		super();
		Id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
		this.foto = foto;
		this.tipo = tipo;
		this.token = token;
	}
	

	
	public UsuarioLogin() {
		super();
	}




	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	
	
}
