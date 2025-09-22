# 🌊 Simulador de Hidrômetro Analógico

Primeiro projeto desenvolvido para a disciplina **Padrões de Projetos** do **IFPB** (Instituto Federal de Educação, Ciência e Tecnologia da Paraíba).

![Imagem do Hidrômetro](https://images.steamusercontent.com/ugc/12714535732358554828/71FDD39A8659C6186284B0902D98512A22611111/)

## 📋 Sobre o Projeto

Sistema de simulação de um hidrômetro digital que replica o comportamento real de um medidor de água, incluindo:

- **Medição de volume** consumido
- **Detecção de ar** na tubulação
- **Simulação de falta d'água**
- **Monitoramento** de pressão e vazão de água
- **Interface gráfica** com imagem de hidrômetro real
- **Display no console** para depuração
- **Geração automática de diretório com capturas** numeradas de 01-99 a cada m³
- **Regulagem manual** do parâmetro de vazão de água em tempo real na janela do simulador

## 🏗️ Diagrama de Classe (UML)

![Diagrama UML](https://www.plantuml.com/plantuml/png/jLZVRYEtzRxNK_3dc_Lcr_-HNri33QB8NiSBE-lQtaMB832EXaSoMmuvFUG8Qe9zZbvlUr4qztq2lLX93YMEXZDgkqM3OAqXFvu_Xn-_mvclZGMoTIdPWoXh2LpJqxU2aoxHadvwVtip6lqVnvbGoEul9u_ZxwvkBbaXmPZHg8BY3p17jgTfVeXBA2k9U-od4MEiWR1R4CeFnFzUbUvv7sXkpjc39Q7ct__myfmjjE01yt7qiT_gOQ7LJCotZK_2M4rGW6uvEHZV_-RzzOTtJvDttxsvlbfxOhzcUnmi75L04B8pXtPfzzAw1Vm8-XQMeeHpndKzbUWM7HyU7v_y_o-wCA4oM898KGgBOshDdsm1q5Ytt8e5Z2dpU9gWQtVZUTsDwVYNPsS9LH4Q0xfjvV3BRa0NQB4ed3NgvhTjIazXAgJWmF4DI0kPzvE4vg7-iHujjDIXv5-wG7CmB7DmgD4MMYYBj02fnxO6ANw4mYVeHYCq8UT8G1EehBFlg3NLMY8e1xDKOu_100NJtfvMoHDTsmpRVvaC5K24Sw2x3PNs4utN6190O_fZBHRwSecEnJe3lPgZ_P1Ov-PZH3q8eOOHDv5l0zEN6Tk6FGMk3StVDIpR6KKYsQ2HFduDW2zoUaMmvqmEJUJQ1RtkOPO72cKJJfYhDgtyV2HMPgjDgauYkoIDEcgPXBSjPuLMrkjoSrGchQU4uS9K4lvqpYwQ7sa6bINWRk5bywDjDv7RsqrFNV7nHSgahYqymvXCxOOmCxzXYaUbIoVOZPkj8omAeNFfo4Lc9wRKt155kPW3vJE7MLDGEz8Z7tTvpkx3tpHkYcVajKHoBIZ-v4u9YjfgUa1QY09xD2UH82fEojjJTLXq4eoQNbw0pX5GIL40JJGHDgSqPBZEBP4thOXdXDRKoumcI5jfSjW2ISn4uLCm1kPO1b1-genJebJsxG0p2ULeWaEwtUnfxjduWeGCk2Wqcbo9Ao2WVe7MiYxnKLkGEsNJrs2tRkw2T2gNGOIvtUPijt8Vmxz9JRQKegqdYvJF4ACjbfM-3aUjevu7jVHn9jrCWBnv9lyjAhy2xkqgQEgwlRklMPzMVCQk41gqQKFxAnGbiLsS5CsGrWrCxnRKl3hHz_xmefVvWVWNHy6a3jq9TV3YiPkm_tOlgyLs9tiB2YNqzxFdpUWvIuZ_h2zPKNfPVVH_qgWelQXysxB_JJsR8I6_zZC9A66ACemvsNvxuvzQdKXJ2O6vhfrYuOpADs6e3n8BbIFRnqKtP8qt2RwBGC5e19hDPJT1RiUFzzUJzpVZzclDwV7fsSd9gRjhd_rgBs7lnW-FuwVRoulhoRlBXxYWxwHsTsk_VujUinrapI_7JNs_0OEv7hVQMRW_pQ0OH55BR8PQpsux70sgPw0BuDfuQyBipq_vERiYg9v5OKul1jVSQMTNaCvMl6QDa0uTiODA6r60tc40nLB_Dcnoy_jtyJSNSs5rV2XqMP4eKSMHdaWjKYaKq8C5MvkkeYOfs2cnYHwPtOd-BqrFjDJKwRMxTZNT51v0BjPKwklEj9vyUtTvbTifmaaAznBWgV_cif1UsUv0A9I-UP6Mk179jtVWXfDhN8gfsDrVrfTnzjDdA4Voj65uDBVVVY58fV_ChV7HP-6bgrx3yTkpd2V_8_wbHlE2tQE4S5K8x3UZy3NfuE2hzelIEVExbgRQefHDPcqf0aQjeIyE3hQkJXxZ7bT_Bxkek1_3WDZZUm5zmTR6XH8N3SvdEMG5qLE3j80CEMZoXUDWXOglVbQ50CDmQP4KcD4M-F3mg_ulQCwCNFtCeFdMaRiD2mqLHoK8TKHeT4q5cYFV6XBigEdUJxDQSNrOgRct6ti9Q-O6JDyY5wk_hVw1vkdxJN_yuUYBmzzN6AnucM1H2inefBH5PdN5z8nvQWJAUPdMZ2F3M7_tV_Ekv4p_LGVCH6lYg82bzXKc6TScwBHMRZMQ4IhEl9VeYyJysNflsMLc4lEhW5P_QKhgZArB6JUYWNu0gGcDWtBoFWrkOCe_ur8OAwWnImAIaURZ4uFQQd_iYd2Si1kan9cFiNibYqBeJmEhIAX2L21zSPfNgbISAoJqz67scH2uyRMCqfLGyIkpFm_hFMCEBGpR3ny067-n-ZIluJK3UjdiYzSMYwo8WinAK7M8m2kUDzl9OwgjozDdadqg6HTry1v4pI71e9jdM4PJRFLd5bvzrfaRmJrrAgG2bSyb94LC0RFrT2lzUpHecnglFbbHQAOqaoB4xaQMeimYZHJiaZgOszncs9nMdtmhJDLlSccNrgSG0lV5bEljY7Cf9c0Sqpb8kvkgkX30ZFHP3t8ugbudIXvso7XJ5P1tDAqRBM_wMep5qlhjJtgUhpjP05x4FXAXpg89_SG3ZJ0kFsW5zRNxMPVodm00)
- **Feito com [PlantUML](https://plantuml.com/)**

### 🏛️ Arquitetura do Sistema em Camadas

O sistema segue arquitetura **MVC (Model-View-Controller)** adaptada:

- **Model** (`core`): Lógica de negócio (Hidrometro, ContadorAgua, Entrada)
- **View** (`ui`): Interfaces visuais (JanelaHidrometro, Display)
- **Controller** (`Main`): Coordenação entre camadas
- **Config** (`config`): Configurações e parametrização

### 📦 Estrutura de Pacotes

- **`org.example`** - Classe principal e ponto de entrada
- **`org.example.config`** - Sistema de configurações externa
- **`org.example.core`** - Núcleo da simulação do hidrômetro
- **`org.example.ui`** - Interfaces de usuário (gráfica e console)

## 🚀 Como Usar

### Pré-requisitos

- **Java 21** instalado
- **Git** para clonar o repositório
- **Gradle** (ou use o Gradle wrapper incluído)
- **IntelliJ IDEA** (recomendado) ou outra IDE Java

### 1. Clonando o Repositório

```bash
# Clone o repositório
git clone https://github.com/tacitojuno/Simulador-Hidrometro-Analogico

# Entre no diretório
cd Hidrometro_PP
```

### 2. Configuração no IntelliJ IDEA

```bash
# Abra o IntelliJ IDEA
# File → Open → Selecione a pasta do projeto
# Aguarde a indexação automática do projeto
# Configure Java 21: File → Project Structure → Project SDK
```

### 3. Executando o Projeto

#### Via Gradle Wrapper (Recomendado):
```bash
# Linux/Mac
./gradlew run

# Windows
gradlew.bat run

# Executar com logs detalhados
./gradlew run --info

# Limpar e executar
./gradlew clean run

# Compilar sem executar
./gradlew build

# Executar testes (se configurados)
./gradlew test

# Gerar JAR
./gradlew jar

# Executar JAR gerado
java -jar build/libs/Hidrometro_PP.jar
```

#### Via IntelliJ IDEA:
1. Abra `src/main/java/org/example/Main.java`
2. Clique em **Run** ou pressione `Ctrl+Shift+F10`

#### Via Terminal (Java direto):
```bash
# Compile o projeto
javac -cp src/main/java src/main/java/org/example/Main.java

# Execute
java -cp src/main/java org.example.Main
```

### 4. Estrutura de Arquivos Necessária

```
simulador-hidrometro/
├── src/
│   └── main/
│       ├── java/
│       │   └── org/example/                    # Pacote raiz
│       │       ├── Main.java                   # ← Ponto de entrada
│       │       ├── config/                     # Configurações
│       │       │   └── Configuracao.java      # ← Gerenciamento de parâmetros
│       │       ├── core/                       # Lógica principal
│       │       │   ├── Hidrometro.java        # ← Controlador principal
│       │       │   ├── ContadorAgua.java      # ← Mecanismo de contagem
│       │       │   └── Entrada.java           # ← Controle de entrada
│       │       └── ui/                         # Interfaces
│       │           ├── JanelaHidrometro.java  # ← Interface gráfica
│       │           └── Display.java           # ← Console (debug)
│       └── resources/
│           └── BaseHidrometro/                 # Recursos gráficos
│               └── imagem_fundo.png            # ← Imagem do hidrômetro
├── data/                                       # Dados de configuração
│   └── parametros.txt                          # ← Configurações do sistema
├── docs/                                       # Dados de configuração
│   └── (Diagrama UML) Simulador de Hidrômetro Analógico V2.pdf
├── MEDICOES/                                   # Imagens geradas automaticamente
│   ├── 00.jpeg                                 # ← Capturas 01-99 por m³
│   ├── 01.jpeg
│   └── ...
├── build/                                      # Arquivos gerados (Gradle)
│   ├── classes/                                # Classes compiladas
│   └── libs/                                   # JARs gerados
├── gradle/                                     # Wrapper do Gradle
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew                                     # Script Gradle (Linux/Mac)
├── gradlew.bat                                 # Script Gradle (Windows)
├── build.gradle                                # Configuração do Gradle
├── settings.gradle                             # Configurações do projeto
└── README.md                                   # ← Este arquivo
```

## ⚙️ Configuração

### Arquivo `data/parametros.txt`

```properties
# Configurações do Hidrômetro

# Pressão (bar)
pressao=2.5

# Vazão (m³/s)
vazao.agua=0.000833         # 50 L/min
vazao.maxima=0.00167        # 100 L/min
vazao.minima=0.0

# Detecção de Ar (%)
limite.ar=10.0
estimativa.ar.maxima=20.0
limite.deteccao.ar=0.00133  # 80 L/min

# Simulação de Falta de Água
probabilidade.falta.agua=0.01           # 1% de chance por segundo
duracao.minima.falta.agua=5000          # 5 segundos
duracao.maxima.falta.agua=7000          # 7 segundos

# Interface
intervalo.atualizacao=1000            # 1 segundo
gerar.capturas=true                   # Habilitar/Desabilitar captura de imagens
intervalo.capturas=0.01               # 1 m³ no contador |0001|00|
```

## 🔗 Principais Relacionamentos Explicados

### **1. Main → Sistema**
```java
// Main cria e coordena todos os componentes principais
Hidrometro hidrometro = new Hidrometro();           // ← Núcleo
Configuracao configuracao = new Configuracao();     // ← Parâmetros  
JanelaHidrometro janela = new JanelaHidrometro(hidrometro, configuracao); // ← Interface
```

### **2. Hidrometro ↔ Componentes Internos**
```java
// Hidrometro CONTÉM (composição) outros objetos
private ContadorAgua contadorAgua;    // ← Contagem de volume
private Display display;              // ← Output console
private Entrada entrada;              // ← Controle de entrada
private Configuracao configuracao;   // ← Acesso a parâmetros
```

### **3. JanelaHidrometro → Hidrometro/Configuracao**
```java
// JanelaHidrometro OBSERVA (dependency) Hidrometro/Configuracao
double volume = hidrometro.getVolumeTotal();     // ← Consulta dados
double vazao = hidrometro.getVazaoAtual();       // ← Consulta dados
double pressao = hidrometro.getPressaoAtual();   // ← Consulta dados
double estimativaAr = hidrometro.getEstimativaAr(); // ← Consulta dados

timer = new Timer(configuracao.getIntervaloAtualizacao(), e -> atualizarInterface()); //Atualização da janela
// Timer atualiza interface baseado no estado do Hidrometro
```

### **4. Configuracao ↔ Arquivo Externo**
```java
// Configuracao CARREGA (uses) arquivo externo
Properties props = new Properties();
props.load(new FileInputStream("data/parametros.txt")); // ← Lê arquivo
// Todos os outros componentes DEPENDEM de Configuracao para parâmetros
```

### **5. Passagem de Dados Entre Camadas**
```
[Entrada] → [Hidrometro] → [ContadorAgua] → [UI]
   ↑             ↓              ↓           ↑
 Sensor       Processa      Acumula     Exibe
 Values       Threads       Volume      Status
```

## 🖼️ Interface Gráfica

### Recursos da Interface:

- **Contador digital** com 6 dígitos
- **Ponteiros analógicos** para decimais
- **Status em tempo real**:
    - ✅ FUNCIONAMENTO NORMAL
    - 🚨 FALTA DE ÁGUA
    - ⚠️ ALERTA - AR NA TUBULAÇÃO
    - ⚠️ ALERTA - VAZAMENTO
    - 🔶 PRESSÃO BAIXA
    - ⚫ SEM FLUXO

### Dados Exibidos:

- **Volume total** acumulado
- **Pressão atual** (bar)
- **Estimativa de ar** (%)
- **Horário** atual
- **Status** do sistema

## 🎛️ Controle de Regulagem Manual:
- **Slider de ajuste** para vazão de água em tempo real

## 🔧 Funcionalidades

1. **Contagem de volume** baseada em vazão × tempo
2. **Detecção automática** de ar na tubulação
3. **Simulação aleatória** de falta d'água
4. **Variação natural** de pressão e vazão
5. **Reset automático** quando atinge limite máximo
6. **Geração de diretório** que armazena capturas da janela do hidrômetro a cada m³

## 🧪 Testando o Sistema

### Cenários de Teste:

1. **Funcionamento normal** - Observe contagem regular
2. **Falta d'água** - Aguarde evento aleatório
3. **Detecção de ar** - Durante/após falta d'água
4. **Reset automático** - Deixe atingir 999.999 m³
5. **Configuração personalizada** - Modifique `parametros.txt`
6. **Geração de imagens** - Verifique pasta `MEDICOES/`
7. **Ajuste manual** - Use slider para alterar vazão

## 🐛 Solução de Problemas

### Erros Comuns:

#### `Imagem não encontrada`
```bash
# Verifique se existe o arquivo:
src/main/resources/BaseHidrometro/imagem_fundo.png

# Ou use uma imagem padrão (será gerada automaticamente)
```

#### `Arquivo de configuração não encontrado`
```bash
# O sistema criará automaticamente em:
data/parametros.txt

# Com valores padrão
```

#### `Erro de compilação`
```bash
# Verifique se o Java 21 está instalado:
java -version

# Configure o SDK do projeto no IntelliJ:
# File → Project Structure → Project SDK

# Via Gradle:
./gradlew --version
```

#### `Problemas com Gradle`
```bash
# Limpar cache e rebuildar:
./gradlew clean build --refresh-dependencies

# Verificar wrapper:
./gradlew wrapper --gradle-version 8.5
```

#### `Controles de regulagem não respondem`
````bash
# Verifique se:
1. A simulação não está pausada
2. Os valores estão dentro dos limites válidos estabelecidos no arquivo de parametros.txt
3. A interface foi inicializada corretamente
````

## 👥 Contribuindo

1. Faça um **fork** do projeto
2. Crie uma **branch** para sua feature: `git checkout -b feature/nova-funcionalidade`
3. **Commit** suas mudanças: `git commit -m 'Adiciona nova funcionalidade'`
4. **Push** para a branch: `git push origin feature/nova-funcionalidade`
5. Abra um **Pull Request**

## 📄 Licença

Projeto desenvolvido para fins acadêmicos no **IFPB (Instituição Federal de Ciência e Educação da Paraíba).**

---

**Desenvolvido com JAVA☕ para a disciplina Padrões de Projetos - 2025.2 - IFPB**