package copilot

import org.codehaus.groovy.ast.CodeVisitorSupport
import org.codehaus.groovy.ast.expr.MethodCallExpression

class SourceRebuilder extends CodeVisitorSupport {

    StringBuilder sb = new StringBuilder()

    void visitMethodCallExpression(MethodCallExpression expr) {
        sb << expr.getObjectExpression().getText()
        sb << "." << expr.getMethodAsString()
        sb << "(" << expr.getArguments().getText() << ")"
    }

    String getSource() {
        sb.toString()
    }
}
