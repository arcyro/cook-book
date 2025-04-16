package pl.merito.cookbook.chess;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoveService {
    private final MoveRepository moveRepository;

    public MoveService(MoveRepository moveRepository) {
        this.moveRepository = moveRepository;
    }

    public Move saveMove(Move move) {
        return moveRepository.save(move);
    }

    public List<Move> getAll() {
        return moveRepository.findAll();
    }
}
