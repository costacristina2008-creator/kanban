# Walkthrough - Implementação das Partes 1, 2 e 3 do Exercício Kanban

Resumo da implementação realizada com base no documento `5_exercicioKanbanPassosAlunos.pdf` (Partes 1, 2 e 3).

## Alterações Realizadas

### Parte 1 – Criação das Telas de Autenticação
- **Pacotes e Estrutura**: Criados os pacotes `ui`, `ui.auth`, e `ui.adapter`.
- **Fragments de Autenticação e Splash**:
  - `SplashFragment.kt` e `fragment_splash.xml` (com logo centralizado e fundo padrão).
  - `LoginFragment.kt` e `fragment_login.xml` (campos de e-mail, senha, botão de login, links para criar e recuperar conta).
  - `RegisterFragment.kt` e `fragment_register.xml`.
  - `RecoverAccountFragment.kt` e `fragment_recover_account.xml`.
- **Recursos Visuais e Estilos**:
  - `colors.xml`: Definida a cor padrão (`color_default = #BFA2DB`), tom de roxo escuro (`color_dark_purple = #5A4A6A`) e outras cores de suporte.
  - `themes.xml`: Configurados `windowBackground`, `colorPrimary`, `colorPrimaryVariant` e o estilo `CustomTabLayout`.
  - Drawables/Shapes:
    - **Ícone Inicial**: Atualizado o `ic_logo.xml` utilizando o vetor do arquivo `cat-svgrepo-com.svg` com o tom de roxo mais escuro da paleta (`#5A4A6A`).
    - Criados `bg_edit_text.xml` e `bg_btn.xml` para bordas arredondadas, além dos ícones vetoriais (`ic_back`, `logoutic`, `ic_add_new_task`, `ic_forward`).
  - **Identificação do Aluno**: Adicionado o nome **"Cristina costa teixeira"** (`@string/student_name`) na parte inferior central das telas (`fragment_splash.xml` e `fragment_login.xml`) utilizando o mesmo tom de roxo escuro (`@color/color_dark_purple`), atendendo aos critérios de avaliação da atividade.
- **ViewBinding**: Habilitado no `app/build.gradle.kts`.

### Parte 2 – Navegabilidade Entre Telas
- **Navigation Component**:
  - Criado o grafo de navegação `main_graph.xml` com o destino inicial em `splashFragment`.
  - Configurado o subgráfico `authentication` contendo `loginFragment`, `registerFragment` e `recoverAccountFragment`.
  - Adicionado `homeFragment` e a transição a partir do login.
  - Configurado `app:popUpTo` e `app:popUpToInclusive="true"` para remover a Splash Screen da pilha de navegação.
- **SplashFragment**:
  - Implementado o redirecionamento automático após 1.5 segundos para o fluxo de autenticação.

### Parte 3 – Utilizando o Componente TabLayout
- **ViewPager2 e Abas**:
  - Criada a classe `ViewPagerAdapter.kt` herdando de `FragmentStateAdapter`.
  - Configurado `HomeFragment.kt` e `fragment_home.xml` (com CoordinatorLayout, AppBarLayout, ViewPager2 e TabLayout).
  - Integrado o `TabLayoutMediator` para sincronizar o `TabLayout` com o `ViewPager2` exibindo as abas: **A Fazer** (`TodoFragment`), **Fazendo** (`DoingFragment`) e **Concluído** (`DoneFragment`).
  - Adicionadas as strings de título das abas em `strings.xml`.

## Validação e Testes
- **Build**: O projeto foi compilado com sucesso (`Build finished successfully`) utilizando o AGP 9.4.1 com suporte nativo a built-in Kotlin.
