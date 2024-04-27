# CRUD em memória na linguagem Java _- Luis Felipe Maia_
Este repositório contém um exemplo de um sistema **CRUD (Create, Read, Update, Delete) em memória implementado em Java.** O sistema permite o gerenciamento de informações de clientes, incluindo operações para cadastrar, consultar, alterar e excluir.

<div align="center">
  
  ![Java](https://antoniomedeiros.dev/files/2012/07/java.jpg)

</div>

## Classes e Interfaces
O sistema é composto pelas seguintes classes e interfaces:

* **IClienteDAO:** Esta interface define os métodos que serão usados para interagir com os dados do cliente. Os métodos incluem cadastrar(), excluir(), alterar(), consultar() e buscarTodos().

* **Main:** Esta classe contém a lógica principal do programa. Ela usa uma implementação da interface _IClienteDAO_ para interagir com os dados do cliente.

* **Cliente:** Esta classe representa um cliente com atributos como nome, endereço, cidade, estado e CPF. Ela também inclui métodos para obter e definir esses atributos.

* **ClienteMapDAO:** Esta classe implementa a interface _IClienteDAO_ e usa um HashMap para armazenar os dados do cliente.

## Funcionalidades
O sistema permite ao usuário realizar as seguintes operações:

1. **Cadastrar um novo cliente:** O usuário pode inserir as informações do cliente, que são posteriormente armazenadas no sistema;

2. **Consultar um cliente:** O usuário pode consultar as informações de um cliente existente fornecendo o CPF do cliente;

3. **Alterar as informações de um cliente:** O usuário pode alterar as informações de um cliente existente;

4. **Excluir um cliente:** O usuário pode excluir um cliente existente do sistema;

5. **Sair do sistema:** O usuário pode sair do sistema a qualquer momento.

# Obrigado
Espero que você ache este repositório útil para entender como implementar um sistema CRUD em Java. Se você tiver alguma dúvida ou sugestão, sinta-se à vontade para abrir uma issue. 😄
