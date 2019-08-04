package filereader.criterias;

import filereader.interfaces.Criteria;
import filereader.interfaces.CriteriaBuilder;

import java.util.List;

public class GroupByCriteria implements Criteria {
    private final List<String> selection;
    private final List<String> groupByCols;
    private final List<String> outputHeaders;

    public GroupByCriteria(List<String> selection, List<String> groupByCols, List<String> outputHeaders) {
        this.selection = selection;
        this.groupByCols = groupByCols;
        this.outputHeaders = outputHeaders;
    }

    @Override
    public List<String> getSelection() {
        return selection;
    }

    @Override
    public List<String> groupByCols() {
        return groupByCols;
    }

    @Override
    public List<String> outputHeaders() {
        return outputHeaders;
    }

    public static class GroupByCriteriaBuilder implements CriteriaBuilder<GroupByCriteria>
    {
        public List<String> selection;
        public List<String> groupByCols;
        private List<String> outputHeaders;

        public GroupByCriteriaBuilder select(List<String> selection) {
            this.selection = selection;
            return this;
        }

        public GroupByCriteriaBuilder groupBy(List<String> groupByCols) {
            this.groupByCols = groupByCols;
            return this;
        }

        @Override
        public GroupByCriteria build() {
            GroupByCriteria groupByCriteria = new GroupByCriteria(selection, groupByCols, outputHeaders);
            return groupByCriteria;
        }

        public GroupByCriteriaBuilder headers(List<String> headers) {
            this.outputHeaders = headers;
            return this;
        }
    }
}
