import java.util.*;

public class PlaylistAutomatica extends Playlist {
    private String criterio; // "top", "recomendadas", "recentes"

    public PlaylistAutomatica(String nome, String criterio) {
        super(nome);
        this.criterio = criterio;
    }

    public PlaylistAutomatica(String nome) {
        super(nome);
    }

    public List<Musica> topDezMusicas(ArrayList<Musica> musicas) {
//        Collections.sort(musicas);

        List<Musica> topDez = new ArrayList<>();

        Collections.sort(musicas, Comparator.comparingInt(Musica::getTocadas).reversed());

        System.out.println("\n=== TOP TRÊS MÚSICAS ===");
        for (int i = 0; i < 3; i++) {
            System.out.println("POSIÇÃO: " + (i+1) +
                    "° | MÚSICA: " + musicas.get(i).getTitulo() +
                    " | VEZES TOCADAS " + musicas.get(i).getTocadas() +
                    " | ARTISTA: " + musicas.get(i).getArtista());

            topDez.add(musicas.get(i));
        }

        System.out.println("=== MÚSICAS ADICIONADAS ===");
        System.out.println("=======================\n");
        return topDez;
    }

    @Override
    public void reproduzir() {
        System.out.println("🤖 Playlist Automática: " + nome);
        System.out.println("📊 Critério: " + criterio);
        super.reproduzir();
    }

    public void atualizar(ArrayList<Musica> todasMusicas) {
        musicas.clear();

        if (criterio.equals("top")) {
            // Adicionar músicas mais tocadas
        } else if (criterio.equals("recomendadas")) {
            // Adicionar músicas recomendadas
        }
    }






}