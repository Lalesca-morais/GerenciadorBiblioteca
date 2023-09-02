
---

# Gerenciador de Biblioteca

Este é um sistema de gerenciamento de biblioteca simples criado em Java. Ele permite que você realize operações como criar, consultar e deletar livros e leitores, bem como fazer empréstimos e renovar empréstimos.

---
## Instruções de Uso

Para usar este sistema, siga as instruções abaixo:

### Iniciar o Gerenciador de Biblioteca

Para iniciar o gerenciador de biblioteca e realizar operações de teste, você pode chamar o método `iniciar` no seu programa principal. Esse método realiza uma série de operações de teste para demonstrar o funcionamento do sistema.

```java
public void iniciar() {
    // Realiza operações de teste
    // ...
}
```
---

### Operações Disponíveis

O gerenciador de biblioteca oferece as seguintes operações:

#### Livros

- `criarLivro(String titulo, String id_autor, String ano_publicacao)`: Cria um novo livro no sistema.
- `mostrarTodosOsLivros()`: Exibe todos os livros cadastrados no sistema.
- `consultarLivroPorId(int id)`: Consulta um livro com base no ID.
- `deletarLivro(int id)`: Deleta um livro com base no ID.

#### Leitores

- `criarLeitor(String email, String telefone, String nome)`: Cria um novo leitor no sistema.
- `alterarLeitor(String nome)`: Altera informações de um leitor com base no nome.
- `consultaTodosLeitores()`: Consulta todos os leitores cadastrados no sistema.
- `consultarLeitorPorId(int id)`: Consulta um leitor com base no ID.
- `deletarLeitores(int id)`: Deleta um leitor com base no ID.

#### Empréstimos

- `escolhaEmprestimo()`: Inicia o menu de empréstimos.
- `fazerEmprestimo(String id_usuario, int id_livro, String dataDevolucao)`: Realiza um empréstimo.
- `renovar(Date data_devolucao)`: Renova um empréstimo.
---
### Observações

- Certifique-se de que as conexões com o banco de dados estejam configuradas corretamente antes de usar as operações que envolvem o banco de dados.
- Lembre-se de fazer backup de seus dados importantes antes de executar operações de deleção ou atualização.
- Este é um projeto de demonstração simples e pode ser estendido para atender às suas necessidades específicas.

---