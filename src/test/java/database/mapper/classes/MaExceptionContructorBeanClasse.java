package database.mapper;

class MaExceptionContructorBeanClasse extends MaBeanClasse {

    public MaExceptionContructorBeanClasse(String attr1, Integer attr2) {
        super(attr1, attr2);
        throw new RuntimeException("ÇA VA PAS NON !");
    }
}
