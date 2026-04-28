import java.util.ArrayList;

public class PlaylistAutomatica extends Playlist {
    private String criterio; // "top", "recomendadas", "recentes"

    public PlaylistAutomatica(String nome, String criterio) {
        super(nome);
        this.criterio = criterio;
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