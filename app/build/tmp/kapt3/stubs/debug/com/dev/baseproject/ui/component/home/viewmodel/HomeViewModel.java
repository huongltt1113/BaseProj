package com.dev.baseproject.ui.component.home.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/dev/baseproject/ui/component/home/viewmodel/HomeViewModel;", "Lcom/dev/baseproject/ui/base/BaseViewModel;", "scriptRepository", "Lcom/dev/baseproject/repository/ScriptRepository;", "(Lcom/dev/baseproject/repository/ScriptRepository;)V", "Companion", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends com.dev.baseproject.ui.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.dev.baseproject.repository.ScriptRepository scriptRepository = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "HomeViewModel";
    @org.jetbrains.annotations.NotNull()
    public static final com.dev.baseproject.ui.component.home.viewmodel.HomeViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.dev.baseproject.repository.ScriptRepository scriptRepository) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/dev/baseproject/ui/component/home/viewmodel/HomeViewModel$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}