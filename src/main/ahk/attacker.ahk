; ---------- START SCRIPT
f5::

Loop {	
	borderColor = 0xFF00FFFA

	idleTrapColor = 0xFFFF00
	caughtTrapColor = 0x00FF00
	fallenTrapColor = 0xAA00FF
	;disTrapColor = 0x2B3DAC
	;idleTrapColor = 0x2EA6B3
	;caughtTrapColor = 0x2AA047
	
	PixelGetColor, trap1Pos, 291, 207
	PixelGetColor, trap1Idle, 291, 210
	Random, randSleep, 8900, 8950
	positions := getAbsolutePos()
	
	PixelSearch, borderX, borderY,5,5,490, 550, borderColor, 1, Fast, RGB

	if(ErrorLevel) {
		
	}else {
		
		WinActivateBottom, Windows PowerShell
		Sleep, 50
		
		Random, offsetX, -6, 6
		Random, offsetY, 0, 15
		newX := positions[1] + borderX + offsetX
		newY := positions[2] + borderY + offsetY
		Send, dis,%newX%:%newY%
		Sleep, 50
		Send, {Enter}
		
		Random, sleeptime, 9500, 10000
		Sleep, sleeptime
		
		Continue
	}
	
	Random, rand, 200, 210
	
	Sleep, rand
}		

; ---------- STOP THE SCRIPT
f12::
ExitApp

getAbsolutePos(){
	WinGetPos, X, Y, width, heigth, RuneLite
	ar := [X,Y]
	return ar	
}