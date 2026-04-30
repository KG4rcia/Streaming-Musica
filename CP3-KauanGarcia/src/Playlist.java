import java.util.ArrayList;
import java.util.List;

public class Playlist {
    protected String nome;
    protected List<Musica> musicas = new ArrayList<>();
    protected String descricao;


    public Playlist(String nome) {
        this.nome = nome.toUpperCase();
    }

    public void reproduzir() {
        System.out.println("🎵 Reproduzindo playlist: " + nome);

        for (Musica m : musicas) {
            System.out.println("  ▶ " + m.getTitulo());
        }

    }

    public boolean temMusica() {
        if (musicas.isEmpty()) {
            return false;
        }
        return true;
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
        musica.addPlaylist();
        System.out.println("--- MUSICA ADICIONADA ---");
    }

    public void removerMusica(Musica musica) {
        musicas.remove(musica);
        System.out.println("--- MUSICA REMOVIDA ---");
    }

    public void listarMusicas() {
        System.out.println();
        System.out.println("--------------------");
        System.out.println("POSIÇÃO | NOME | ARTISTA");
        for (int i = 0; i < musicas.size(); i++) {
            System.out.println((i+1) + " | " + musicas.get(i).getTitulo() + " | " + musicas.get(i).getArtista());
        }
    }

    public double getDuracaoTotal() {
        if (musicas.isEmpty()) {
            return 0;
        }

        double total = 0;
        for (Musica musica : musicas) {
            total += musica.getDuracaoSegundos();
        }
        return total;
    }

    public int getQuantidadeMusicas() {
        return musicas.size();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        if (musicas.isEmpty()) {
            System.out.println("A lista está vazia, não há como colocar ela.");
            return;
        }

        this.musicas = musicas;
    }
}
