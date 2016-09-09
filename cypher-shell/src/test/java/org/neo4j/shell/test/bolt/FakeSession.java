package org.neo4j.shell.test.bolt;

import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.types.TypeSystem;

import java.util.Map;

/**
 * A fake session which returns fake StatementResults
 */
public class FakeSession implements Session {
    private boolean open = true;

    @Override
    public Transaction beginTransaction() {
        return new FakeTransaction();
    }

    @Override
    public Transaction beginTransaction(String bookmark) {
        return null;
    }

    @Override
    public String lastBookmark() {
        return null;
    }

    //    @Override
    public void reset() {
    }

    @Override
    public boolean isOpen() {
        return open;
    }

    @Override
    public void close() {
        open = false;
    }

    @Override
    public String server() {
        return null;
    }

    @Override
    public StatementResult run(String statementTemplate, Value parameters) {
        return FakeStatementResult.parseStatement(statementTemplate);
    }

    @Override
    public StatementResult run(String statementTemplate, Map<String, Object> statementParameters) {
        return FakeStatementResult.parseStatement(statementTemplate);
    }

    @Override
    public StatementResult run(String statementTemplate, Record statementParameters) {
        return FakeStatementResult.parseStatement(statementTemplate);
    }

    @Override
    public StatementResult run(String statementTemplate) {
        return FakeStatementResult.parseStatement(statementTemplate);
    }

    @Override
    public StatementResult run(Statement statement) {
        return new FakeStatementResult();
    }

    @Override
    public TypeSystem typeSystem() {
        return null;
    }
}
