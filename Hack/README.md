
# HackSimulator

Simulador de carreira hacker em Java, com sistema de login/cadastro, evolução de habilidades, Ozzy Coin, loja, missões dinâmicas e especiais.

## Como jogar

1. Execute o projeto pelo arquivo `Main.java`.
2. Crie um usuário ou faça login.
3. Complete missões para ganhar experiência e Ozzy Coins.
4. Evolua habilidades (Hacking, Engenharia Social, Criptografia) usando Ozzy Coins.
5. Compre itens na loja para melhorar seu desempenho.
6. Missões especiais aparecem para jogadores de nível 5 ou superior, com grandes recompensas.

## Funcionalidades

- **Login/Cadastro**: Sistema simples para criar e acessar perfis.
- **Missões**: Diversas missões com diferentes dificuldades e recompensas. Missões especiais disponíveis para jogadores avançados.
- **Habilidades**:
  - Hacking: aumenta chance de sucesso nas missões.
  - Engenharia Social: reduz dificuldade dos desafios intermediários.
  - Criptografia: reduz energia perdida em missões avançadas.
- **Evolução de habilidades**: Use Ozzy Coins para evoluir habilidades, com custo crescente.
- **Loja**: Compre energia extra, upgrades de nível e ferramentas de hack.
- **Sistema de energia**: Energia é consumida em missões e pode ser recuperada descansando ou comprando itens.
- **Ozzy Coin**: Moeda do jogo, usada para evoluir habilidades e comprar itens.

## Estrutura do projeto

- `src/modelos/hack/`: Classes de modelo (Jogador, Missao, Usuario, Alvo)
- `src/servicos/hack/`: Lógica principal do jogo (`GameEngine.java`)
- `src/utilidades/hack/`: Funções utilitárias (validação, formatação, etc)
- `src/principal/hack/`: Ponto de entrada (`Main.java`)
- `bin/`: Arquivos compilados
- `lib/`: Dependências

## Requisitos

- Java 8+
- VS Code ou outro IDE compatível

## Como compilar e executar

1. Compile os arquivos Java:
	- `javac -d bin src/modelos/hack/*.java src/servicos/hack/*.java src/utilidades/hack/*.java src/principal/hack/*.java`
2. Execute o jogo:
	- `java -cp bin principal.hack.Main`

## Personalização

- Para adicionar novas missões, edite o método `carregarMissoes()` em `GameEngine.java`.
- Para criar missões especiais, edite o método `adicionarMissoesEspeciais()`.
- Para ajustar habilidades ou loja, edite as respectivas funções nas classes `Jogador` e `GameEngine`.

## Créditos

Desenvolvido por [Seu Nome].
