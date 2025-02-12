package com.dev.baseproject.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/dev/baseproject/repository/ScriptRepository;", "", "clickerDao", "Lcom/dev/baseproject/data/dao/ClickerDao;", "(Lcom/dev/baseproject/data/dao/ClickerDao;)V", "insertNewScript", "", "listClick", "", "Lcom/dev/baseproject/data/entity/ClickerEntity;", "Companion", "app_debug"})
public final class ScriptRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.dev.baseproject.data.dao.ClickerDao clickerDao = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "ScriptRepository";
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.repository.ScriptRepository.Companion Companion = null;
    
    @javax.inject.Inject()
    public ScriptRepository(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.data.dao.ClickerDao clickerDao) {
        super();
    }
    
    public final void insertNewScript(@org.jetbrains.annotations.NotNull()
    java.util.List<com.dev.baseproject.data.entity.ClickerEntity> listClick) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/dev/baseproject/repository/ScriptRepository$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}