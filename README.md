# 📅 **Projeto de Agendamento de Laboratório**

Bem-vindo(a) ao meu repositório do **Projeto de Agendamento de Laboratório**! Este projeto simula um sistema de agendamento de horários para laboratórios, permitindo que professores reservem horários para aulas em diferentes laboratórios de uma instituição. 💻

## 📚 **Sobre o Projeto**

O objetivo deste projeto é criar um sistema de agendamento onde:

- **Professores** podem realizar login, cadastrar suas disciplinas e agendar horários para o uso de laboratórios.
- **Laboratórios** são disponibilizados para agendamento com horários predefinidos e as reservas de cada professor são visualizadas por todos.
- O sistema inclui validação de login, cadastro e agendamento, com a visualização de horários disponíveis e ocupados em uma interface gráfica.

---

## 🚀 **Funcionalidades**

- **Cadastro e Login**: Professores podem se cadastrar e fazer login para acessar o sistema.
- **Agendamento de Laboratórios**: Professores podem agendar horários disponíveis.
- **Visualização de Horários**: Todos os agendamentos feitos são visíveis para outros professores, indicando os horários ocupados.
- **Validação de Dados**: O sistema valida os dados durante o cadastro e login para garantir que os campos estejam preenchidos corretamente.
- **Interação com Calendário**: A interface exibe um calendário semanal onde é possível ver os horários livres (em verde) e ocupados (em vermelho).

---

## 🖥️ **Tecnologias Utilizadas**

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- **Java** ☕ (para o desenvolvimento da interface gráfica e a lógica do sistema)
- **Swing** 🖼️ (para a construção da interface gráfica)
- **Persistência de Dados** 📦 (armazenamento de dados de login e agendamentos)

---

## 🛠️ **Funcionalidades Implementadas**

1. **Cadastro de Professor**: O professor insere suas informações (nome, matrícula e senha) para se cadastrar no sistema.
2. **Login de Professor**: Após o cadastro, o professor pode acessar sua conta com matrícula e senha.
3. **Visualização de Horários**: O sistema mostra uma tabela com horários livres e ocupados para cada laboratório.
4. **Agendamento de Horários**: O professor pode agendar múltiplos horários para sua disciplina, com a opção de desmarcar caso seja necessário.
5. **Persistência de Dados**: As informações de login, cadastro e agendamentos são salvas para serem acessadas em sessões futuras.

---

## 📂 **Estrutura de Arquivos**

AgendamentoDeLaboratorio/ │ └── src/ │ └── ifpb/ │ └── edu/ │ └── br/ │ └── main/ │ ├── controller/ │ ├── Controlador.java │ ├── Dados.java │ ├── dao/ │ ├── DisciplinaDAO.java │ ├── DisciplinaDAOImpl.java │ ├── ProfessorDAO.java │ ├── ProfessorDAOImpl.java │ ├── Serializador.java │ ├── StringSerializer.java │ ├── model/ │ ├── Disciplina.java │ ├── Laboratorio.java │ ├── Professor.java │ └── view/ ├── BlocoDeHorario.java ├── BotaoAlocacao.java ├── CalendarioSemanal.java ├── GerenciadorDeTelas.java ├── InfoBloco.java ├── JanelaCalendario.java ├── TelaCalendario.java ├── TelaCadastro.java ├── TelaLogin.java └── TelaPrincipal.java

---

## 🤔 **Por Que Criar Esse Projeto?**

Este projeto foi criado para:

- Aplicar conceitos de Programação Orientada a Objetos (POO) em um sistema real.
- Resolver o problema de agendamento e gerenciamento de horários de laboratórios de forma simples e eficiente.
- Proporcionar uma experiência de aprendizado ao trabalhar com interfaces gráficas, persistência de dados e controle de acesso de usuários.
- Melhorar minhas habilidades em desenvolvimento de sistemas utilizando Java e Swing.

---

🖤 **Obrigado por visitar este repositório!**
