def call(){
        bat '''
    @echo off
    setlocal enabledelayedexpansion
    set FOUND=0
    for /r src\\main\\webapp\\app %%i in (*.spec.ts) do (
        echo %%i
        set FOUND=1
    )
    if !FOUND! == 0 echo "No test files found"
    '''
    bat 'npm test'
}