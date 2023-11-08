; ---------- START SCRIPT
f5::
disTrapColor = 0xFF0000
idleTrapColor = 0xFFFF00
caughtTrapColor = 0x00FF00
fallenTrapColor = 0xAA00FF

PixelGetColor, trap1Pos, 291, 207
PixelGetColor, trap1Idle, 291, 210
foundTrap := []

Loop {

	; Try to find a trap
		idleTrapColor = 0xFFFF00

	

	if(foundTrap.Count() > 0){
		positions := getAbsolutePos()
		type := foundTrap[1]
		thePosX := foundTrap[2]
		thePosY := foundTrap[3]
		;WinActivateBottom, Windows PowerShell
		;Sleep, 10
	
		Random, offsetX, -6, 6
		Random, offsetY, 0, 15
		
		if(type = "f"){
			newX := positions[1] + (thePosX-20) + offsetX
			newY := positions[2] + (thePosY+10) + offsetY
		}else {
			newX := positions[1] + thePosX + offsetX
			newY := positions[2] + thePosY + offsetY
		}
		
		
		;Send, %type%,%newX%:%newY%
		;Sleep, 50
		;Send, {Enter}
		ControlSend, ,%type%`,%newX%`:%newY%{Enter},Windows PowerShell
		
		Random, random, 16000,16500
		
		Sleep, random
		
		foundTrap := []
		
		Continue
	} else {
		foundTrap := searchTrap()
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

searchTrap(){
	disTrapColor = 0xFF0000
	idleTrapColor = 0xFFFF00
	caughtTrapColor = 0x00FF00
	fallenTrapColor = 0xAA00FF
	
		trap := []
		;PixelSearch, trapFallenX, trapFallenY,14,107,508, 365, fallenTrapColor, 1, Fast, RGB
		PixelSearch, trapFallenX, trapFallenY,105,84,485, 346, fallenTrapColor, 1, Fast, RGB

		if(ErrorLevel) {
				
			
		}else {
			trap := ["f", trapFallenX, trapFallenY]
			return trap
		}
		
		PixelSearch, trapChtX, trapChtY,105,84,485, 346, caughtTrapColor, 1, Fast
		if(ErrorLevel) {
		}else {
			trap := ["c",trapChtX, trapChtY]
			return trap
		}
		
		PixelSearch, trapDisX, trapDisY,105,84,485, 346, disTrapColor, 1, Fast, RGB
		if(ErrorLevel) {
			
		}else {
			trap := ["d",trapDisX, trapDisY]
			return trap
		}
}

; IMPORTANT, coords based on default zoom
searchOthers(){
	disTrapColor = 0xFF0000
	idleTrapColor = 0xFFFF00
	caughtTrapColor = 0x00FF00
	fallenTrapColor = 0xAA0073
	
	playerXMin =
	playerYMin = 
	playerXMax =
	playerYMax = 
	
	return pos
}