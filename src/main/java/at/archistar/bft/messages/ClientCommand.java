package at.archistar.bft.messages;

import at.archistar.bft.helper.DigestHelper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * this is a command from the client to a replica
 *
 * @author andy
 */
public abstract class ClientCommand extends AbstractCommand {

    private static final long serialVersionUID = -1195268975334641339L;

    private final int clientId;

    private final int clientSequence;

    protected byte[] payload = null;

    String operationId = null;

    public ClientCommand(int clientId, int clientSequence) {
        super();

        this.clientId = clientId;
        this.clientSequence = clientSequence;
    }

    public int getClientId() {
        return this.clientId;
    }

    public int getClientSequence() {
        return this.clientSequence;
    }

    public String getClientOperationId() {

        if (this.operationId != null) {
            return this.operationId;
        }

        return this.operationId = DigestHelper.getClientOperationId(this.clientId, this.clientSequence);
    }

    @SuppressFBWarnings("EI_EXPOSE_REP")
    public byte[] getPayload() {
        return payload;
    }
}
