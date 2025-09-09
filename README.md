# 🌊 Simulador de Hidrômetro Digital

Projeto desenvolvido para a disciplina **Padrões de Projetos** do **IFPB** (Instituto Federal de Educação, Ciência e Tecnologia da Paraíba).

## 📋 Sobre o Projeto

Sistema de simulação de um hidrômetro digital que replica o comportamento real de um medidor de água, incluindo:

- **Medição de volume** consumido
- **Detecção de ar** na tubulação
- **Simulação de falta d'água**
- **Monitoramento de pressão** e vazão
- **Interface gráfica** com imagem de hidrômetro real
- **Display console** para depuração

## 🏗️ Arquitetura do Sistema (UML)

![Diagrama UML](https://www.plantuml.com/plantuml/png/jLZVRjks5xxtK_2NtyMSfV7o1raBemcQEdRh8caofoasB4DnB1qhn2JI9Id3wzg7sNOnx7vla1SRAJ8cJKafqc6vY2Nou-7XuNS-ykYPL21KMUIT_wKuemp9sV7uzRl1-UdvXFn_k3iw60rNNOFprwFnYxlEqVxmO7GGT4w6gt5FHWV39wkkg_5gp4YFskbqvf3y31cI3Iwo7YwXcEUuGPu-dM2YW6Kv7Xs5ZlpQ8VeloK5ASWQKkGRpjrNezow8JFR9fHAKPJ_-jDad2qxJ2lEfywbvkbx2sOncyQn-ZT6yWmfU2aY01_Dl7q--kng_FNzd1zuvGGx9HWeAlfc3W0ALuBAdbch3Zrl01-1diAG5z4dAoscEUj1ERsTdzzl7COoo6in3SbfGXSSYwDzT0w1KUhYY2pWMjHdtB3ISxZWhOvzsdkplUzHSe9J0GokzWzYX4rIO9DgQYDUtRefFOKfpcaAA8yWLr6RVzUZKnj_68q3dl0hvWNQq3ePb7Lp5Q0rDcKAnW9mVgn9o-i4CxHFTQg4UwQaNKgAxwKqb80Hc82vMUzyDAManWe8u5kzBkk339Mf6yXfeAqFrrjF4zDkmD20eQqUSEeAqT0zZUhJFPCdHrdzXQT7cHSIADYEDX6W1dqHyy62poOrGM7uMEcwWWW5IfZwhAIBMiL0OGprvILF1AtQ4Qf9mfY3bmZ9r4Bm5lAPodiClVN9Y7tmFCYKWrGE7zY6qwwbgxFgtEFVDajkKnkPzEoOMcpRCp8IVfKveffpd24o3TBl4C2LfGdazS-ivVYz6cAcAFfbKlxvT9ZUObZaABThkCTMfc9IAYqjD09fWGzBxVUjkHguQhhHdlOU9IrgKkV6xZe1vJXCG0ou4sZJHs-AbrgU17-58AkxOKZFg8M6grs4B57H64xC4AI73meBS_dYShDmtywKquIZhmcLEFT6iPpml2tp35UJjAkCeTf_Cn91sIOiWdwh_GIA6IHQcui9xsiPZXSMSZokMHZAoNUR60oyWCS2x6yuVK6eBKcENWOtOEWqUaQOq-u9u2vIe_5OrHyYfIHWSxqshJ4JT3z8Yxw2Rkzi-A0YPTEonmMeDY_H7LUHgwmdye1El_NmeQNmwN8qRpWOdx670PrmKKF74pQdb7nDQG3wgUXf2jyfwPwuR7YwUIH6nR4GUn3JldjSWcprd-tw4kna7seqAHK4PY4kbVPNTB_J4swrJznKmpA7vhBrPjVQ9HppipDGEcVFZZVdnhRGmwlaoiF-ydCrGO3esFHwOmnJpggtearUdvgrfo-jx_UMiY2FIRGx38zA-_8Qhhbt3Sv3OSkXP9bOtgnaahIWHA6RRENQ_dHGbiXjDUaYvDDQex6PxQP-y432_eOdSEsaTSy6rNIfuRSGZOldSolyvbpG1Vey1f4l-VNM7jCy_kEUKPbHnzvBmOYveWSor-7d-kvo9x0xulpGzu3aNqLNWlbtTmYMTKj6jLUrV4LSVaHGz6s__lFs34rmg58ntR9RxAzURfT82Ew96MrskExyFNObgzQu7MGc7OMNhsekgFZWCwt3NGPdhg1fjZTi3SRYgjNqyTFETeRreGEhg7pCoB8RNwk1UTK5U-MWBO7VLTOw445lsXX1OHf37Tv1LcTi3loU7fi2r8PzW3jMreoAXx5IVMxQtZy9wfKyIGS5tXTeGTzOLs04wGTFNszjhrp23qQ-tVnKnoXrbxG1tNsW6D3XRIksA6zJQ7w-X7X0-bIQiTMIRoRMsNkyeud2VE6KrU_AQAv2QygOqgFWbEumh98hF2P-jEp8m2O6QJfGbT0uvUL-QvE4YHGRN38YzlDiiIZanwd_xTpNQ6XKqkr76RBGXjcOXd1IO0AEoC6bvpKoKZVJh5wUHraoEiygAtmzZJt1jOWxYzdUxrCe4EeWHd2gtRShgnqrhQygLueMnra2crL50Cd7xcobVZ8fUCti6rvVeu-Qvv6qeN9gqk6RciYIv5hGeAj5U3kmkXMkwPdfEg9JBwvJUnLFCaALWnKoWxEHLWpLTvUR7GsrUc9yBICoi7srpy2bKl_Zxf0VuhvOE4d_c392JOGjEU7jNuqPCIJL2-smzxppJ_yeY_mS0)

### 🏛️ Arquitetura em Camadas

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
intervalo.atualizacao=1000              # 1 segundo
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

## 🔧 Funcionalidades

### Simulação Realística:

1. **Contagem de volume** baseada em vazão × tempo
2. **Detecção automática** de ar na tubulação
3. **Simulação aleatória** de falta d'água
4. **Variação natural** de pressão e vazão
5. **Reset automático** quando atinge limite máximo

## 🧪 Testando o Sistema

### Cenários de Teste:

1. **Funcionamento normal** - Observe contagem regular
2. **Falta d'água** - Aguarde evento aleatório
3. **Detecção de ar** - Durante/após falta d'água
4. **Reset automático** - Deixe atingir 999.999 m³
5. **Configuração personalizada** - Modifique `parametros.txt`

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

## 📚 Padrões de Projeto Utilizados

- **Singleton** (implícito em Configuracao)
- **Observer** (JanelaHidrometro observa Hidrometro)
- **Strategy** (diferentes comportamentos por estado)
- **Facade** (Hidrometro simplifica acesso ao sistema)

## 👥 Contribuindo

1. Faça um **fork** do projeto
2. Crie uma **branch** para sua feature: `git checkout -b feature/nova-funcionalidade`
3. **Commit** suas mudanças: `git commit -m 'Adiciona nova funcionalidade'`
4. **Push** para a branch: `git push origin feature/nova-funcionalidade`
5. Abra um **Pull Request**

## 📄 Licença

Este projeto foi desenvolvido para fins acadêmicos no **IFPB**.

---

**Desenvolvido com JAVA☕ para a disciplina Padrões de Projetos - IFPB**