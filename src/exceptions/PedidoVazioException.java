package exceptions;

public class PedidoVazioException extends RuntimeException {
    public PedidoVazioException(String mensagem) {
        super(mensagem);
    }
}
