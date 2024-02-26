/* MyJavaRule.java

        Purpose:
                
        Description:
                
        History:
                Thu Jul 13 22:01:54 CST 2023, Created by rebeccalai

Copyright (C) 2023 Potix Corporation. All Rights Reserved.
*/
package my.pkg;

import com.sun.source.tree.VariableTree;
import org.zkoss.zklinter.JavaFileVisitor;
import org.zkoss.zklinter.Rule;

public class MyJavaRule extends Rule {
    @Override
    protected String getDescription() {
        return "My Custom Java Rule - Found a `div` variable";
    }

    @Override
    public JavaFileVisitor newJavaFileVisitor() {
        return new JavaFileVisitor() {
            @Override
            protected void visitVariable(VariableTree node) {
                if ("div".equals(node.getName().toString())) {
                    report(node, getDescription());
                }
            }
        };
    }
}
