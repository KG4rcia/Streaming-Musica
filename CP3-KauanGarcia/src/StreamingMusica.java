import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StreamingMusica {
    static final String[] GENEROS_VALIDOS = {"Pop", "Rock", "Jazz", "Eletrônica", "Hip-Hop", "Clássica"};
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Musica> musicas = new ArrayList<>();
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static Usuario usuario;

    public static void testes() {
        PlaylistPersonalizada p1 = new PlaylistPersonalizada("Minha primeira Playlist");
        PlaylistPersonalizada p2 = new PlaylistPersonalizada("Academia");
        PlaylistPersonalizada p3 = new PlaylistPersonalizada("Estudando");

        UsuarioPremium usuarioPremium = new UsuarioPremium("KAUAN GARCIA", "GARCIA@GMAIL.COM", "MENSAL");
        UsuarioPremium usuarioPremium2 = new UsuarioPremium("JOÃO FERNANDES", "JOAO@GMAIL.COM", "FAMILIAR");
        UsuarioFree usuarioFree = new UsuarioFree("MARCOS AUGUSTO", "MARCOS@GMAIL.COM");
        UsuarioFree usuarioFree2 = new UsuarioFree("MARIA DA SILVA", "MARIA@GMAIL.COM");

        usuarios.add(usuarioPremium);
        usuarios.add(usuarioPremium2);
        usuarios.add(usuarioFree);
        usuarios.add(usuarioFree2);

        Musica m1 = new Musica("Acabou tudo", "Ronaldinho", 120, "Pop");
        Musica m2 = new Musica("Recomeçou", "Rogerio", 300, "Jazz");
        Musica m3 = new Musica("Nova", "Roberto", 180, "Rock");
        Musica m4 = new Musica("Sol e Lua", "Fernanda", 160, "Rock");
        Musica m5 = new Musica("Estrela Cadente", "Maria", 250, "Pop");
        Musica m6 = new Musica("Little Dark Age", "Trupe", 110, "Rock");

        m1.setTocadas(10);
        m2.setTocadas(50);
        m3.setTocadas(32);
        m4.setTocadas(10);
        m5.setTocadas(67);
        m6.setTocadas(46);

        musicas.add(m1);
        musicas.add(m2);
        musicas.add(m3);
        musicas.add(m4);
        musicas.add(m5);
        musicas.add(m6);

        p1.adicionarMusica(m1); // acabou tudo
        p2.adicionarMusica(m2); // recomeçou
        p2.adicionarMusica(m3); // nova
        p3.adicionarMusica(m4); // sol e lua
        p3.adicionarMusica(m5); // estrela cadente
        p3.adicionarMusica(m6); // little dark age

        p1.adicionarMusica(m6); // little dark age
        p2.adicionarMusica(m6); // little dark age
        p3.adicionarMusica(m6); // little dark age
        p2.adicionarMusica(m4); // Sol e Lua
        p2.adicionarMusica(m4); // Sol e Lua
        p1.adicionarMusica(m4); // Sol e Lua

        p2.adicionarMusica(m5); // Estrela Cadente
        p2.adicionarMusica(m5); // Estrela Cadente

//        usuario.adicionarPlaylist(p1);
//        usuario.adicionarPlaylist(p2);
//        usuario.adicionarPlaylist(p3);
    }

    public static void main(String[] args) {
//        testes();

        usuario = criarUsuario();

        if (usuario == null) {
            System.out.println("\n=== ENCERRANDO... ===");
        } else {
            int opcao;
            do {
                menuGeral();
                opcao = lerOpcao();
                processarEscolhaGeral(opcao);

            } while (opcao != 0);

        }

    }

    public static Usuario criarUsuario() {
        int planoContaUsuario;
        int opcao;
        int tipoContaUsuario = 0;

        while (true) {
            System.out.println("=== SISTEMA DE STREAMING ===");
            System.out.println("1. Criar novo usuário");
            System.out.println("2. Login");
            System.out.println("3. Listar usuários");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção (0-3): ");
            opcao = scanner.nextInt();


            switch (opcao) {
                case 1:
                    scanner.nextLine();
                    String nomeUsuario = "";
                    String emailUsuario = "";

                    do {
                        System.out.print("Digite seu nome: ");
                        nomeUsuario = scanner.nextLine().trim().toUpperCase();

                        if (nomeUsuario.isBlank()) {
                            System.out.println("- ERRO: O campo \"Nome\" não deve estar vazio.");
                        }

                    } while (nomeUsuario.isBlank());

                    do {
                        System.out.print("Digite seu email: ");
                        emailUsuario = scanner.nextLine().trim().toUpperCase();

                        if (emailUsuario.isBlank()) {
                            System.out.println("- ERRO: O campo \"Email\" não deve estar vazio.");
                        }

                    } while (emailUsuario.isBlank());


                    while (true) {
                        try {
                            System.out.println("=== ESCOLHA O TIPO DE CONTA ===");
                            System.out.println("1. Free (Gratuito)");
                            System.out.println("2. Premium (Pago)");
                            System.out.print("Escolha: ");

                            tipoContaUsuario = scanner.nextInt();
                            scanner.nextLine();

                            if (tipoContaUsuario > 3) {
                                throw new IllegalArgumentException("Selecione uma opção válida (1-2)");
                            }

                            break;
                        } catch (IllegalArgumentException e) {
                            System.out.println("- ERRO: " + e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println("- ERRO: Somente números.");
                        }
                    }

                    if (tipoContaUsuario == 2) {
                        while (true) {
                            System.out.println("=== ESCOLHA O PLANO PREMIUM ===");
                            System.out.println("1. Mensal (R$ 19,90)");
                            System.out.println("2. Anual (R$ 199,00)");
                            System.out.println("3. Familiar (R$ 29,90)");
                            System.out.print("Escolha: ");

                            try {
                                planoContaUsuario = scanner.nextInt();

                                if (planoContaUsuario == 1) {
                                    Usuario usuario2 = new UsuarioPremium(nomeUsuario, emailUsuario, "MENSAL");
                                    System.out.println("✅ Conta Premium criada com sucesso!");
                                    scanner.nextLine();

                                    usuarios.add(usuario2);
                                    return usuario2;
                                } else if (planoContaUsuario == 2) {
                                    Usuario usuario2 = new UsuarioPremium(nomeUsuario, emailUsuario, "ANUAL");
                                    System.out.println("✅ Conta Premium criada com sucesso!");
                                    scanner.nextLine();

                                    usuarios.add(usuario2);
                                    return usuario2;
                                } else if (planoContaUsuario == 3) {
                                    Usuario usuario2 = new UsuarioPremium(nomeUsuario, emailUsuario, "FAMILIAR");
                                    System.out.println("✅ Conta Premium criada com sucesso!");
                                    scanner.nextLine();

                                    usuarios.add(usuario2);
                                    return usuario2;
                                } else {
                                    throw new IllegalArgumentException("Escolha uma opção válida (1-3).");
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("- ERRO: Somente números inteiros.");
                                scanner.nextLine();
                            } catch (IllegalArgumentException e) {
                                System.out.println("- ERRO: " + e.getMessage());
                            }
                        }

                    }

                    Usuario usuario1 = new UsuarioFree(nomeUsuario, emailUsuario);
                    System.out.println("✅ Conta Free criada com sucesso!");
                    usuarios.add(usuario1);

                    return usuario1;
                case 2:
                    if (usuarios.isEmpty()) {
                        System.out.println("- ERRO: Não há usuários cadastrados.");
                        break;
                    }

                    int idUsuarios = 0;
                    int posicaoUsuarioLogin = 0;

                    System.out.println("\n=== USUÁRIOS CADASTRADOS ===");
                    for (Usuario u : usuarios) {
                        idUsuarios++;
                        if (u instanceof UsuarioFree) {
                            System.out.println("ID: " + idUsuarios + " | NOME: " + u.getNome() + " | PLANO: GRATUITO" + " | EMAIL: " + u.getEmail());
                        } else if (u instanceof UsuarioPremium) {
                            UsuarioPremium u2 = (UsuarioPremium) u;
                            System.out.println("ID: " + idUsuarios + " | NOME: " + u2.getNome() + " | PLANO: PREMIUM " + u2.getPlano().toUpperCase() + " | EMAIL: " + u2.getEmail());
                        }

                    }

                    System.out.println("===============================\n");

                    while (true) {
                        try {
                            System.out.print("Informe o ID para realizar o login: ");
                            posicaoUsuarioLogin = scanner.nextInt();
                            scanner.nextLine();

                            return usuarios.get(posicaoUsuarioLogin-1);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("- ERRO: Por favor, inserir uma posição válida.");
                        } catch (InputMismatchException e) {
                            System.out.println("- ERRO: Somente números, nada de letras.");
                        }

                    }

                case 3:
                    if (usuarios.isEmpty()) {
                        System.out.println("- ERRO: Não há usuários cadastrados.");
                        break;
                    }

                    System.out.println("\n=== USUÁRIOS CADASTRADOS ===");
                    for (Usuario u : usuarios) {
                        if (u instanceof UsuarioFree) {
                            System.out.println("NOME: " + u.getNome() + " | PLANO: GRATUITO" + " | EMAIL: " + u.getEmail());
                        } else if (u instanceof UsuarioPremium) {
                            UsuarioPremium u2 = (UsuarioPremium) u;
                            System.out.println("NOME: " + u2.getNome() +
                                    " | PLANO: PREMIUM " + u2.getPlano().toUpperCase() +
                                    " | EMAIL: " + u2.getEmail());
                        }
                    }
                    System.out.println("===============================\n");


                    break;
                case 0:
                    return null;
                default:
                    System.out.println("- ERRO: Selecione uma opção válida.");
                    scanner.nextLine();
            }

        }

    }

    public static void menuFree() {
        System.out.println("-".repeat(20));
        System.out.println("=== SISTEMA DE STREAMING DE MÚSICA ===");
        System.out.println("1. Reproduzir Música");
        System.out.println("2. Ver histórico");
        System.out.println("3. Criar playlist (máx. 3)");
        System.out.println("4. 💎 Fazer upgrade para Premium");
        System.out.println("5. Adicionar música a uma playlist");
        System.out.println("0. Sair");
        System.out.print("\n- Sua escolha: ");
        int escolhaFree = scanner.nextInt();
        scanner.nextLine();
        processarDadosFree(escolhaFree);
    }

    public static void processarDadosFree(int escolha) {
        UsuarioFree usuarioFree = (UsuarioFree) usuario;

        switch (escolha) {
            case 1:
                reproduzirMusica();
                break;
            case 2:
                usuarioFree.exibirHistorico();
                break;
            case 3:
                criarPlaylist();
                break;
            case 4:
                assinarPremium();
                break;
            case 5:
                adicionarMusica();
            case 0:
                return;
            default:
                System.out.println("- ERRO: Escolha inválida.");
        }

    }

    public static void menuPremium() {
        System.out.println("-".repeat(20));
        System.out.println("=== SISTEMA DE STREAMING DE MÚSICA ===");
        System.out.println("1. Reproduzir música (Alta Qualidade)");
        System.out.println("2. Ver histórico");
        System.out.println("3. Criar playlist (ilimitado)");
        System.out.println("4. Baixar música");
        System.out.println("5. Ver músicas baixadas");
        System.out.println("6. Adicionar música a uma playlist");
        System.out.println("0. Sair");
        System.out.print("\n- Sua escolha: ");
        int escolhaPremium = scanner.nextInt();
        scanner.nextLine();
        processarDadosPremium(escolhaPremium);
    }

    public static void processarDadosPremium(int escolha) {
        UsuarioPremium usuarioPremium = (UsuarioPremium) usuario;

        switch (escolha) {
            case 1:
                reproduzirMusica();
                break;
            case 2:
                usuarioPremium.exibirHistorico();
                break;
            case 3:
                criarPlaylist();
                break;
            case 4:
                baixarMusica();
                break;
            case 5:
                usuarioPremium.listarMusicasBaixadas();
                break;
            case 6:
                adicionarMusica();
            case 0:
                return;
            default:
                System.out.println("- ERRO: Escolha inválida.");
        }

    }

    public static void baixarMusica() {
        if (musicas.isEmpty()) {
            System.out.println("- ERRO: Não há músicas para baixar.");
        }

        if (usuario instanceof UsuarioPremium) {
            UsuarioPremium usuarioPremium = (UsuarioPremium) usuario;

            for (int i = 0; i < musicas.size(); i++) {
                System.out.println("ID: " + (i+1) + " | NOME: " + musicas.get(i).getTitulo().toUpperCase() + " | ARTISTA: " + musicas.get(i).getArtista().toUpperCase());
            }

            while (true) {
                try {
                    System.out.print("- Informe a música pelo ID (Digite \"0\" para cancelar a operação): ");
                    int idMusica = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (idMusica == -1) {
                        System.out.println("\n=================");
                        System.out.println("🎵 Saindo....");
                        System.out.println("===================\n");
                        break;
                    }

                    Musica musica = musicas.get(idMusica);
                    usuarioPremium.baixarMusica(musica);
                    System.out.println("🎵 Música baixada com sucesso!");
                    break;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("- ERRO: Insira o ID válido.");
                } catch (InputMismatchException e) {
                    System.out.println("- ERRO: Somente números.");
                    scanner.nextLine();
                }
            }

        }
    }

    public static void assinarPremium() {
        System.out.println("-".repeat(20));
        System.out.println("Escolha o plano Premium:");
        System.out.println("1. Mensal (R$ 19,90)");
        System.out.println("2. Anual (R$ 199,00)");
        System.out.println("3. Familiar (R$ 29,90)");

        while (true) {
            try {
                System.out.print("Escolha: ");
                int planoContaUsuario = scanner.nextInt();
                scanner.nextLine();

                if (planoContaUsuario > 3) {
                    throw new IllegalArgumentException("Insira uma opção válida (1-3).");
                }

                while (true) {
                    try {

                        if (planoContaUsuario == 1) {
                            System.out.println("✅ Conta atualizada pro Premium criada com sucesso!");
                            usuario = new UsuarioPremium(usuario, "Mensal");

                            break;
                        } else if (planoContaUsuario == 2) {
                            System.out.println("✅ Conta atualizada pro Premium criada com sucesso!");
                            usuario = new UsuarioPremium(usuario, "Anual");

                            break;
                        } else if (planoContaUsuario == 3) {
                            System.out.println("✅ Conta atualizada pro Premium criada com sucesso!");
                            usuario = new UsuarioPremium(usuario, "Familiar");

                            break;
                        } else {
                            throw new IllegalArgumentException("Escolha uma opção válida (1-3).");
                        }
                    }  catch (InputMismatchException e) {
                        System.out.println("- ERRO: Somente números inteiros.");
                        scanner.nextLine();
                    } catch (IllegalArgumentException e) {
                        System.out.println("- ERRO: " + e.getMessage());
                    }

                }

                System.out.println("\n==========================");
                System.out.println("🎵 Agora você é um Usuário Premium!");
                System.out.println("==========================\n");

                break;
            } catch (IllegalArgumentException e) {
                System.out.println("- ERRO: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("- ERRO: Somente números, nada de letras.");
            }
        }
    }

    public static void reproduzirMusica() {

        if (usuario instanceof UsuarioFree) {
            UsuarioFree usuarioFree = (UsuarioFree) usuario;

            if (usuarioFree.getPlaylists().isEmpty()) {
                System.out.println("- ERRO: O usuário não tem nenhuma playlist.");
                return;
            }

            do {
                for (int i = 0; i < usuarioFree.getPlaylists().size(); i++) {
                    Playlist playlist = usuarioFree.getPlaylist(i);

                    System.out.println("\n========================");
                    System.out.println("🎵 - PLAYLIST: \"" + playlist.getNome().toUpperCase().trim() + "\" - ");
                    System.out.println("========================\n");

                    for (int j = 0; j < playlist.getMusicas().size(); j++) {
                        usuarioFree.reproduzirMusica(playlist.getMusicas().get(j));


                        while (true) {
                            System.out.print("- Continuar? [SIM/NÃO]: ");
                            String continuar = scanner.nextLine().trim().toUpperCase();

                            if (continuar.equals("SIM")) {
                                break;
                            } else if (continuar.equals("NÃO")) {
                                System.out.println();
                                return;
                            } else {
                                System.out.println("- ERRO: Argumento inválido.");
                            }
                        }

                    }
                }

            } while (true);

        } else if (usuario instanceof  UsuarioPremium) {
            UsuarioPremium usuarioPremium = (UsuarioPremium) usuario;

            if (usuarioPremium.getPlaylists().isEmpty()) {
                System.out.println("- ERRO: O usuráio não tem nenhuma playlist.");
                return;
            }

            do {
                for (int i = 0; i < usuarioPremium.getPlaylists().size(); i++) {
                    Playlist playlist = usuarioPremium.getPlaylist(i);

                    System.out.println("\n========================");
                    System.out.println("🎵 - PLAYLIST: \"" + playlist.getNome().toUpperCase().trim() + "\" - ");
                    System.out.println("========================\n");

                    for (int j = 0; j < playlist.getMusicas().size(); j++) {
                        usuarioPremium.reproduzirMusica(playlist.getMusicas().get(j));

                        while (true) {
                            System.out.print("- Continuar? [SIM/NÃO]: ");
                            String continuar = scanner.nextLine().trim().toUpperCase();

                            if (continuar.equals("SIM")) {
                                break;
                            } else if (continuar.equals("NÃO")) {
                                System.out.println();
                                return;
                            } else {
                                System.out.println("- ERRO: Argumento inválido.");
                            }
                        }

                    }
                }

            } while (true);

        }

    }

    public static void processarEscolhaGeral(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarMusica();
                break;
            case 2:
                listarMusicas();
                break;
            case 3:
                buscarMusicaPorNome();
                break;
            case 4:
                criarPlaylist();
                break;
            case 5:
                if (usuario instanceof UsuarioFree) {
                    menuFree();
                } else if (usuario instanceof UsuarioPremium) {
                    menuPremium();
                }
                break;
            case 6:
                exibirEstatisticas();
                break;
            case 7:
                usuario = criarUsuario();
                break;
            case 0:
                System.out.println("\n🎵 Obrigado por usar o Sistema de Streaming! Até logo! 🎵\n");
                break;
            default:
                System.out.println("❌ Opção inválida");
                break;
        }
    }

    public static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void menuGeral() {
        System.out.println("-".repeat(20));
        System.out.println("=== SISTEMA DE STREAMING DE MÚSICA ===");
        System.out.println("1. Cadastrar música");
        System.out.println("2. Listar todas as músicas");
        System.out.println("3. Buscar música");
        System.out.println("4. Criar playlist");
        System.out.println("5. Gerenciar Playlist & Conta");
        System.out.println("6. Exibir estatísticas");
        System.out.println("7. Voltar");
        System.out.println("0. Sair");
        System.out.println("-".repeat(20));
        System.out.print("Escolha uma opção: ");

    }

    public static void cadastrarMusica() {
        System.out.println("\n--- CADASTRAR MÚSICA ---");

        System.out.print("Título: ");
        String titulo = scanner.nextLine().trim();

        if (titulo.isEmpty()) {
            System.out.println("❌ Título não pode ser vazio!");
            return;
        }

        System.out.print("Artista: ");
        String artista = scanner.nextLine().trim();

        if (artista.isEmpty()) {
            System.out.println("❌ Artista não pode ser vazio!");
            return;
        }

        System.out.print("Duração (em segundos): ");
        int duracao;

        try {
            duracao = Integer.parseInt(scanner.nextLine());

            if (duracao <= 0 || duracao > 3600) {
                throw new NumberFormatException();
            }

        } catch (NumberFormatException e) {
            System.out.println("❌ Duração inválida! A duração não pode ultrpassar 3600 segundo e não pode ter menos de 0 segundos.");
            return;
        }

        System.out.println("\nGêneros disponíveis:");
        for (int i = 0; i < GENEROS_VALIDOS.length; i++) {
            System.out.println((i + 1) + ". " + GENEROS_VALIDOS[i]);
        }

        System.out.print("Escolha o gênero (1-" + GENEROS_VALIDOS.length + "): ");
        int opcaoGenero;
        try {
            opcaoGenero = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Opção inválida!");
            return;
        }

        if (opcaoGenero < 1 || opcaoGenero > GENEROS_VALIDOS.length) {
            System.out.println("❌ Gênero inválido!");
            return;
        }

        String genero = GENEROS_VALIDOS[opcaoGenero - 1];

        Musica musica = new Musica(titulo, artista, duracao, genero);
        musicas.add(musica);
        System.out.println("✅ Música cadastrada com sucesso!");
    }

    public static void listarMusicas() {
        if (musicas.isEmpty()) {
            System.out.println("-".repeat(20));
            System.out.println("❌ Opção inválida: Não há músicas disponiveis.");
            return;
        }

        System.out.println("\nPOSIÇÃO | MÚSICAS | ARTISTA | GÊNERO | DURAÇÃO");
        for (int i = 0; i < musicas.size(); i++) {
            System.out.println((i+1) + " | "
                    + musicas.get(i).getTitulo() + " | "
                    + musicas.get(i).getArtista() + " | "
                    + musicas.get(i).getGenero() + " | "
                    + formatarDuracao((int) (musicas.get(i).getDuracaoSegundos())));
        }
        System.out.println();

    }

    public static void buscarMusicaPorNome() {
        if (musicas.isEmpty()) {
            System.out.println("-".repeat(20));
            System.out.println("❌ Opção inválida: Não há músicas disponiveis.");
            return;
        }
        System.out.println("-".repeat(20));
        System.out.print("Informe uma parte ou o nome completo: ");
        String nomeMusica = scanner.nextLine();

        for (Musica musica : musicas) {
            if (musica.getTitulo().toLowerCase().contains(nomeMusica.toLowerCase())) {
                System.out.println("✅ Música encontrada!");
                musica.exibir();
                return;
            }
        }
        System.out.println("❌ Música não foi encontrada.");
    }

    public static void criarPlaylist() {
        if (musicas.isEmpty()) {
            System.out.println("-".repeat(20));
            System.out.println("❌ Opção inválida: Não há músicas disponiveis.");
            return;
        }

        int escolhaPlaylist;
        String nomePlaylist;

        if (usuario instanceof UsuarioPremium) {

            while (true) {
                try {
                    System.out.println("=".repeat(20));
                    System.out.println("1. PlayList Personalizada.");
                    System.out.println("2. PlayList Automatica.");
                    System.out.print("- Sua escolha: ");
                    escolhaPlaylist = scanner.nextInt();
                    scanner.nextLine();

                    if (escolhaPlaylist > 2) {
                        throw new IllegalArgumentException("\n- ERRO: Escolha uma opção válida.\n");
                    }

                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\n- ERRO: Somente números, nada de letras.\n");
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (escolhaPlaylist == 1) {
                System.out.println("=".repeat(20));
                UsuarioPremium usuarioPremium = (UsuarioPremium) usuario;
                System.out.print("- Informe o nome da playlist: ");
                nomePlaylist = scanner.nextLine();
                usuarioPremium.criarPlaylist(nomePlaylist);

            } else if (escolhaPlaylist == 2) {
                System.out.println("=".repeat(20));
                UsuarioPremium usuarioPremium = (UsuarioPremium) usuario;
                int playlistAutomatica;

                while (true) {
                    try {
                        System.out.println("=== PLAYLISTS AUTOMÁTICAS ===");
                        System.out.println("1. Top 03 mais tocadas...");
                        System.out.println("2. Recomendadas para você...");
                        System.out.println("3. Adicionadas recentemente...");
                        System.out.print("Sua escolha: ");
                        playlistAutomatica = scanner.nextInt();
                        scanner.nextLine();

                        if (playlistAutomatica > 3 || playlistAutomatica < 1) {
                            throw new IllegalArgumentException("Informe uma opção válida, ela deve estar entre 1 e 3.");
                        }

                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("- ERRO: Somente números, nada de letras.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("- ERRO: " + e.getMessage());
                    }

                }

                if (playlistAutomatica == 1) {
                    System.out.print("- Informe o nome da playlist: ");
                    nomePlaylist = scanner.nextLine();

                    PlaylistAutomatica playlistAutomatica1 = new PlaylistAutomatica(nomePlaylist);
                    playlistAutomatica1.setMusicas(playlistAutomatica1.fazerPlaylist(musicas, "tops"));
                    usuario.adicionarPlaylist(playlistAutomatica1);

                } else if (playlistAutomatica == 2) {
                    System.out.print("- Informe o nome da playlist: ");
                    nomePlaylist = scanner.nextLine();

                    PlaylistAutomatica playlistAutomatica1 = new PlaylistAutomatica(nomePlaylist);
                    playlistAutomatica1.setMusicas(playlistAutomatica1.fazerPlaylist(musicas, "recomendadas"));
                    usuario.adicionarPlaylist(playlistAutomatica1);

                } else if (playlistAutomatica == 3) {
                    System.out.print("- Informe o nome da playlist: ");
                    nomePlaylist = scanner.nextLine();

                    PlaylistAutomatica playlistAutomatica1 = new PlaylistAutomatica(nomePlaylist);
                    playlistAutomatica1.setMusicas(playlistAutomatica1.fazerPlaylist(musicas, "recentes"));
                    usuario.adicionarPlaylist(playlistAutomatica1);
                }

            }


        } else if (usuario instanceof UsuarioFree) {

            while (true) {
                try {
                    System.out.println("=".repeat(20));
                    System.out.println("1. PlayList Personalizada.");
                    System.out.println("2. PlayList Automatica.");
                    System.out.print("- Sua escolha: ");
                    escolhaPlaylist = scanner.nextInt();
                    scanner.nextLine();

                    if (escolhaPlaylist > 2) {
                        throw new IllegalArgumentException("- ERRO: Escolha uma opção válida.");
                    }

                    break;
                } catch (InputMismatchException e) {
                    System.out.println("- ERRO: Somente números, nada de letras.");
                    scanner.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println("- ERRO: " + e.getMessage());
                    scanner.nextLine();
                }
            }

            if (escolhaPlaylist == 1) {
                System.out.println("=".repeat(20));
                UsuarioFree usuarioFree = (UsuarioFree) usuario;
                System.out.print("- Informe o nome da playlist: ");
                nomePlaylist = scanner.nextLine();
                usuarioFree.criarPlaylist(nomePlaylist);

            } else if (escolhaPlaylist == 2) {
                System.out.println("=".repeat(20));
                UsuarioFree usuarioFree = (UsuarioFree) usuario;
                int playlistAutomatica;

                while (true) {
                    try {
                        System.out.println("=== PLAYLISTS AUTOMÁTICAS ===");
                        System.out.println("1. Top 03 mais tocadas...");
                        System.out.println("2. Recomendadas para você...");
                        System.out.println("3. Adicionadas recentemnte...");
                        System.out.println("Sua escolha: ");
                        playlistAutomatica = scanner.nextInt();
                        scanner.nextLine();

                        if (playlistAutomatica > 3 || playlistAutomatica < 3) {
                            throw new IllegalArgumentException("Informe uma opção válida, ela deve estar entre 1 e 3.");
                        }

                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("- ERRO: Somente números, nada de letras.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("- ERRO: " + e.getMessage());
                    }
                }

                if (playlistAutomatica == 1) {
                    System.out.print("- Informe o nome da playlist: ");
                    nomePlaylist = scanner.nextLine();

                    PlaylistAutomatica playlistAutomatica1 = new PlaylistAutomatica(nomePlaylist);
                    playlistAutomatica1.setMusicas(playlistAutomatica1.fazerPlaylist(musicas, "tops"));
                    usuario.adicionarPlaylist(playlistAutomatica1);

                } else if (playlistAutomatica == 2) {
                    System.out.print("- Informe o nome da playlist: ");
                    nomePlaylist = scanner.nextLine();

                    PlaylistAutomatica playlistAutomatica1 = new PlaylistAutomatica(nomePlaylist);
                    playlistAutomatica1.setMusicas(playlistAutomatica1.fazerPlaylist(musicas, "recomendadas"));
                    usuario.adicionarPlaylist(playlistAutomatica1);

                } else if (playlistAutomatica == 3) {
                    System.out.print("- Informe o nome da playlist: ");
                    nomePlaylist = scanner.nextLine();

                    PlaylistAutomatica playlistAutomatica1 = new PlaylistAutomatica(nomePlaylist);
                    playlistAutomatica1.setMusicas(playlistAutomatica1.fazerPlaylist(musicas, "recentes"));
                    usuario.adicionarPlaylist(playlistAutomatica1);
                }

            }

        }

    }

    // lista todas as playlists
    public static void listarPlayList() {
        if (usuario.getPlaylists().isEmpty()) {
            System.out.println("-".repeat(20));
            System.out.println("❌ Opção inválida: Não há playlists disponiveis.");
            return;
        }

        usuario.listarPlaylist();
    }

    // Adiciona música a playlist
    public static void adicionarMusica() {
        if (usuario.getPlaylists().isEmpty()) {
            System.out.println("-".repeat(20));
            System.out.println("- ERRO: Você não criou nenhuma playlist até o momento.");
            return;
        }
        listarPlayList();
        int numPlaylist;
        int numMusica;

        try {
            System.out.println("Informe a posição da Playlist: ");
            numPlaylist = scanner.nextInt();
            Playlist playlist = usuario.getPlaylist(numPlaylist-1);

            listarMusicas();
            System.out.print("Informe a posição da Música: ");
            numMusica = scanner.nextInt();
            scanner.nextLine();

            Musica musica = musicas.get(numMusica-1);
            playlist.adicionarMusica(musica);

        } catch (IndexOutOfBoundsException e) {
            System.out.println("❌ Por favor, preencha o campo corretamente.");
        }

    }

    // remove música de playlist
    public static void removerMusica() {
        listarPlayList();
        int numPlaylist;
        int musicaRemover = 0;
        boolean verificandoSeTemMusica;

        try {
            // Pegando a playlist
            System.out.print("Informe a posição da Playlist: ");
            numPlaylist = scanner.nextInt();
            Playlist playlist = usuario.getPlaylist(numPlaylist-1);
            scanner.nextLine();

            // Se tiver musica, ele retorna true, se não, false
            verificandoSeTemMusica = usuario.getPlaylist(numPlaylist-1).temMusica();

            if (verificandoSeTemMusica) {
                playlist.listarMusicas(); // Listando as músicas da playlist
                System.out.print("Escolha a posição da música para remover: ");

                try {
                    musicaRemover = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("❌ Por favor, preencha o campo corretamente.");
                }

                Musica musica = playlist.getMusicas().get(musicaRemover-1);
                scanner.nextLine();

                playlist.removerMusica(musica);
                System.out.println("✅ Música removida!");
            } else {
                System.out.println("--------------------");
                System.out.println("❌ Essa Playlist está vazia.");
            }


        } catch (IndexOutOfBoundsException e) {
            System.out.println("❌ Por favor, preencha o campo corretamente.");
        }

    }

    public static void exibirDetalhesDeUmaPlaylist() {
        try {
            System.out.println("-".repeat(20));
            System.out.print("Informe uma parte ou o nome completo da playlist: ");
            String nomePlaylist = scanner.nextLine().trim();

            for (Playlist playlist : usuario.getPlaylists()) {
                if (playlist.getNome().toLowerCase().contains(nomePlaylist.toLowerCase())) {
                    System.out.println("\n---");
                    System.out.println("🎶 PLAYLIST: ");
                    System.out.println("NOME: " + playlist.getNome() + " | QUANT. MÚSICAS: "
                            + playlist.getQuantidadeMusicas() + " | DURAÇÃO TOTAL: "
                            + formatarDuracao((int) (playlist.getDuracaoTotal())));

                    System.out.println();

                    if (playlist.temMusica()) {
                        System.out.println("🎧 MÚSICAS DA PLAYLIST: ");
                        System.out.println("MÚSICA | ARTISTA | GÊNERO | DURAÇÃO");
                        for (Musica musica : playlist.getMusicas()) {
                            System.out.println(musica.getTitulo() + " | " + musica.getArtista() + " | " + musica.getGenero() + " | " + formatarDuracao((int) (musica.getDuracaoSegundos())));
                        }
                    }

                }

            }


        } catch (IndexOutOfBoundsException e) {
            System.out.println("❌ Por favor, preencha o campo corretamente.");
        }
    }

    public static void exibirEstatisticas() {
        System.out.println("-".repeat(20));
        System.out.println("\n--- ESTATÍSTICAS DO SISTEMA ---");
        double duracaoTotal = 0;
        int usuariosFree = 0;
        int usuariosPremium = 0;
        int reproducaoTotal = 0;
        int reproducaoPremium = 0;
        int anunciosExibidos = 0;
        int reproducaoFree = 0;

        System.out.println("Total de usuários: " + usuarios.size());
        for (Usuario usuario1 : usuarios) {
            if (usuario1 instanceof UsuarioFree) {
                usuariosFree++;
                reproducaoTotal += usuario1.getHistoricoReproducao().size();
                reproducaoFree += usuario1.getHistoricoReproducao().size();
                anunciosExibidos += ((UsuarioFree) usuario1).getAnuncios();
            } else {
                usuariosPremium++;
                reproducaoTotal += usuario1.getHistoricoReproducao().size();
                reproducaoPremium += usuario1.getHistoricoReproducao().size();
            }
        }

        System.out.println("- Free: " + usuariosFree + " usuários");
        System.out.println("- Premium: " + usuariosPremium + " usuários");



        System.out.println("\nReproduções Totais: " + reproducaoTotal);
        System.out.printf("- Free: %d (%.2f%%)%n", reproducaoFree, ((double) reproducaoFree * 100.0) / reproducaoTotal);
        System.out.printf("- Premium: %d (%.2f%%)%n", reproducaoPremium, ((double) reproducaoPremium * 100.0) / reproducaoTotal);
        System.out.println("\nAnúncios exibidos: " + anunciosExibidos);

//        System.out.println("Total de músicas: " + musicas.size());
//        for (int i = 0; i < musicas.size(); i++) {
//            duracaoTotal += musicas.get(i).getDuracaoSegundos();
//        }
//
//        System.out.println("Duração total: " + formatarDuracao((int) (duracaoTotal)));
//        System.out.println("Duração média: " + formatarDuracao((int) (duracaoTotal/musicas.size())));
     }

    public static String formatarDuracao(int segundos) {
        int minutos = segundos / 60;
        int segs = segundos % 60;
        return String.format("%d:%02d", minutos, segs);
    }

}