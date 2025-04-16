package pl.merito.cookbook.chess;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/move")
public class MoveController {
    private final MoveService moveService;

    public MoveController(MoveService moveService) {
        this.moveService = moveService;
    }

    @PostMapping
    public void saveMove(@RequestBody Move move) {
        moveService.saveMove(move);
    }

    @GetMapping()
    public List<Move> getMoves() {
        return moveService.getAll();

    }
}
