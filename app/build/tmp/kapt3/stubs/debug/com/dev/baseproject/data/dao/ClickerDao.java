package com.dev.baseproject.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\'\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nH\'J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\'J!\u0010\u000e\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\'\u00a2\u0006\u0002\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/dev/baseproject/data/dao/ClickerDao;", "", "()V", "delete", "", "clickerEntity", "", "Lcom/dev/baseproject/data/entity/ClickerEntity;", "([Lcom/dev/baseproject/data/entity/ClickerEntity;)V", "models", "", "deleteByScriptId", "idScript", "", "insert", "app_debug"})
@androidx.room.Dao()
public abstract class ClickerDao {
    
    public ClickerDao() {
        super();
    }
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.data.entity.ClickerEntity... clickerEntity);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.data.entity.ClickerEntity... clickerEntity);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    java.util.List<com.dev.baseproject.data.entity.ClickerEntity> models);
    
    @androidx.room.Query(value = "DELETE FROM clicker_entity WHERE idScript = :idScript")
    public abstract void deleteByScriptId(int idScript);
}