package database.mapper;

import database.bean.Bean;

class MaBeanClasse implements Bean {

    private String attr1;
    private Integer attr2;

    public MaBeanClasse(String attr1, Integer attr2) {
        this.attr1 = attr1;
        this.attr2 = attr2;
    }

    @Override
    public Object[] getObjectValues() {
        return new Object[]{attr1, attr2};
    }
}
