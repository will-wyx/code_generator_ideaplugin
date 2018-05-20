import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;

import java.util.List;

import static java.util.Objects.nonNull;

public class NewBundle extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        Project project = e.getData(CommonDataKeys.PROJECT);
        if (nonNull(psiFile)) {
            PsiElement element = psiFile.getFirstChild().getContext();
            if (nonNull(element)) {
                String context = element.getText();
                context = context.toLowerCase();
                try {
                    Statement statement = CCJSqlParserUtil.parse(context);
                    CreateTable createTable = (CreateTable) statement;
                    String tableName = createTable.getTable().getName();
                    List<ColumnDefinition> columnDefinitions = createTable.getColumnDefinitions();
                    Messages.showMessageDialog(tableName, "title", Messages.getInformationIcon());
                } catch (JSQLParserException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
